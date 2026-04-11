package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.exception.UserNotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Lazy
    private OrderService proxyObj;

    public OrderResponse createOrder(OrderRequest request) {
 
        String userUrl = "http://USER-SERVICE/users/" + request.getUserId();
        User user = restTemplate.getForObject(userUrl, User.class);

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        Product product = proxyObj.fetchProduct(request.getProductId());

        double total = product.getPrice() * request.getQuantity();
        Long orderId = new Random().nextLong(10000);

        return new OrderResponse(orderId, user.getName(), product.getName(), request.getQuantity(), total);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "productFallback")
    public Product fetchProduct(Long productId) {
        String productUrl = "http://PRODUCT-SERVICE/products/" + productId;
        return restTemplate.getForObject(productUrl, Product.class);
    }

    public Product productFallback(Long productId, Throwable ex) {
        System.out.println("Circuit breaker triggered: " + ex.getMessage());
        Product fallback = new Product();
        fallback.setId(productId);
        fallback.setName("Fallback product name");
        fallback.setPrice(0.0);
        return fallback;
    }
}
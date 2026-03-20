package SpringAssignments.JDBC_JPA_Test14March.src.main.java.dao;


import entity.Order;
import java.util.List;

public interface OrderDao {

    void addOrder(Order order);

    Order viewOrderById(int id);

    List<Order> viewOrdersByCustomerName(String name);
}
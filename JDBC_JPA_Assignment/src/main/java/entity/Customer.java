package entity;
import java.util.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name", nullable=false, length=45)
    private String customerName;

    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Order> orders;

    public Customer() {}

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    public static void addOrder() {
    	
    	Scanner scan = new Scanner(System.in);

        System.out.println("Enter Customer ID");
        int cid = scan.nextInt();

        System.out.println("Enter Customer Name");
        String cname = scan.next();

        System.out.println("Enter Order Amount");
        double amt = scan.nextDouble();

        Customer cust = new Customer();
        cust.setCustomerId(cid);
        cust.setCustomerName(cname);

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderAmt(amt);

        // setting relationship
        order.setCustomer(cust);

        dao.addOrder(order);

        System.out.println("Order Added Successfully");
    }
}
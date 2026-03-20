package SpringAssignments.JDBC_JPA_Test14March.src.main.java.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="abes_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Temporal(TemporalType.DATE)
    @Column(name="order_date")
    private Date orderDate;

    @Column(name="order_amt")
    private double orderAmt;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {}

    public Order(Date orderDate, double orderAmt, Customer customer) {
        this.orderDate = orderDate;
        this.orderAmt = orderAmt;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
package dao;


import entity.Order;
import jakarta.persistence.*;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    @Override
    public void addOrder(Order order) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(order);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Order viewOrderById(int id) {

        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, id);
        em.close();

        return order;
    }

    @Override
    public List<Order> viewOrdersByCustomerName(String name) {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select o from Order o where o.customer.customerName=:name");

        q.setParameter("name", name);

        List<Order> list = q.getResultList();

        em.close();

        return list;
    }
}
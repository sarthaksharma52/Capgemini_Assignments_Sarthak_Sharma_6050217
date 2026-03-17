package cg.demo.associationMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        System.out.println("Starting App!");

        // Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Start transaction
        em.getTransaction().begin();

        // -------- First Record --------
        IndianPassport ip1 = new IndianPassport();
        ip1.setPassportNo(12345);
        ip1.setPassportExpireData(LocalDate.of(2028, 5, 13));

        Citizen ct1 = new Citizen();
        ct1.setName("Sarthak Sharma");
        ct1.setAddress("Duryai , Gb nagar , 203207");
        ct1.setAdharNo(9876);

        ip1.setCitizen(ct1);

        // Persist passport (Citizen will also persist due to cascade)
        em.persist(ip1);

        // -------- Second Record --------
        IndianPassport ip2 = new IndianPassport();
        ip2.setPassportNo(77345);
        ip2.setPassportExpireData(LocalDate.of(2028, 5, 13));

        Citizen ct2 = new Citizen();
        ct2.setName("Sona Sharma");
        ct2.setAddress("Lalkua , Ghaziabad , 262402");
        ct2.setAdharNo(5676);

        ip2.setCitizen(ct2);

        em.persist(ip2);

        // Commit transaction
        em.getTransaction().commit();

        // Close resources
        em.close();
        emf.close();

        System.out.println("Data Saved Successfully!");
    }
}
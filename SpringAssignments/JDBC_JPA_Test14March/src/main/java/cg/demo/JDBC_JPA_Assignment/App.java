package SpringAssignments.JDBC_JPA_Test14March.src.main.java.cg.demo.JDBC_JPA_Assignment;

import java.util.*;
import dao.*;
import entity.*;

public class App {

   static OrderDao dao = new OrderDaoImpl();
   static Scanner scan = new Scanner(System.in);

   public static void main(String[] args) {

      String opt = null;

      do {

         System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");

         int mtype = scan.nextInt();

         processMenu(mtype);

         System.out.println("press y to continue");
         opt = scan.next();

      } while(opt.equalsIgnoreCase("y"));

   }

   public static void processMenu(int mtype) {

      switch(mtype) {

         case 1:
            addOrder();
            break;

         case 2:
            viewOrderByOrderID();
            break;

         case 3:
            viewOrdersByCustName();
            break;

         default:
            System.out.println("Invalid option");
      }
   }

   public static void addOrder() {

      System.out.println("Enter Order Amount");
      double amt = scan.nextDouble();

      System.out.println("Enter Customer ID");
      int cid = scan.nextInt();

      Customer cust = new Customer();
      cust.setCustomerId(cid);

      Order order = new Order();
      order.setOrderAmt(amt);
      order.setOrderDate(new Date());
      order.setCustomer(cust);

      dao.addOrder(order);

      System.out.println("Order Added Successfully");
   }

   public static void viewOrderByOrderID() {

      System.out.println("Enter Order ID");
      int id = scan.nextInt();

      Order order = dao.viewOrderById(id);

      if(order!=null){

         System.out.println(order.getOrderId()+" "
                 +order.getOrderAmt()+" "
                 +order.getCustomer().getCustomerName());
      }
      else{
         System.out.println("Order not found");
      }
   }

   public static void viewOrdersByCustName() {

      System.out.println("Enter Customer Name");
      String name = scan.next();

      List<Order> list = dao.viewOrdersByCustomerName(name);

      for(Order o:list){

         System.out.println(o.getOrderId()+" "
                 +o.getOrderAmt()+" "
                 +o.getOrderDate());
      }
   }
}
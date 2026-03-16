package cg.demo.Assignment2;

/**
 * Hello world!
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;


/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("springConf.xml");

        Employee emp = context.getBean("emp", Employee.class);

        emp.display();
    }
}
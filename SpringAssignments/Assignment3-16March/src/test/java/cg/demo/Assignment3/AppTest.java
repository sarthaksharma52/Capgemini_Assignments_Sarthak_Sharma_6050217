package cg.demo.Assignment3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.SBU;

public class AppTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("springConf.xml");

        SBU sbu = (SBU) context.getBean("sbu");

        sbu.display();
    }
}
package com.harsh;


//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj = factory.getBean(Alien.class);
        obj.temp();
//        System.out.println(obj.getAge());
    }
}
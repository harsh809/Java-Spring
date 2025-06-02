package com.harsh;

import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;
    private Computer com;

//    public Alien() {
//        System.out.println("created object");
//    }
//
//    public Alien(int age) {
//        this.age = age;
//    }

    public void temp(){
        System.out.println("I'm Coding");
        com.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }
}

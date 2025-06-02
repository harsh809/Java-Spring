package com.harsh;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(1);
        s.setName("Harsh");
        s.setAge(30);

        Laptop l = new Laptop();
        l.setLid(101);
        l.setLname("HP");
        s.getLaptop().add(l);
        l.setStudents(s);
        SessionFactory sf = new Configuration()
                                .addAnnotatedClass(Student.class)
                                .addAnnotatedClass(Laptop.class)
                                .configure()
                                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(s);
        session.persist(l);
        tx.commit();
        session.close();
        sf.close();

    }
}
package com.harsh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args){
        AlienName an = new AlienName();
        an.setFname("navin");
        an.setLname("reddy");
        an.setMname("kumar");

        Alien temp = new Alien();
        temp.setId(3);
        temp.setName(an);
        temp.setAge(45);

//        Configuration conf = new Configuration();
//        conf.addAnnotatedClass(com.harsh.Alien.class);
//        conf.configure("hibernate.cfg.xml");

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.harsh.Alien.class)
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(temp);
//        session.merge(temp);
//        Alien a1 = session.get(Alien.class, 4);
//        session.remove(a1);
        tx.commit();

        //fetching data
//        Alien a1 = session.byId(Alien.class).getReference(2);
//        Alien a1= session.get(Alien.class, 1);
//        System.out.println(a1);
        session.close();
        sf.close();
    }
}
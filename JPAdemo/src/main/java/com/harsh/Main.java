package com.harsh;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p-unit");
        EntityManager em = emf.createEntityManager();
        Alien alien = em.find(Alien.class, 3);
//        System.out.println(alien);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        em.remove(alien);
//        em.merge(alien);
        tx.commit();
        em.close();
        emf.close();
    }
}
package com.basic.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;

        try {
            // Open session
            session = HibernateUtil.getSessionFactory().openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Create User object
            User user = new User();
            user.setName("Kshitij");
            user.setEmail("kshitij@gmail.com");

            // Save object
            session.persist(user);

            // Commit transaction
            transaction.commit();

            System.out.println("User saved successfully!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        HibernateUtil.getSessionFactory().close();
    }
}
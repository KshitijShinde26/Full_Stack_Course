package com.basic.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
public class App {

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        Scanner in = new Scanner(System.in);
        try {
            // Open session
            session = HibernateUtil.getSessionFactory().openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Create User object
            User user = new User();
            System.out.println("Enter user:");
            String name = in.nextLine();
            user.setName(name);
            System.out.println("Enter Email:");
            String email = in.nextLine();
            user.setEmail(email);

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
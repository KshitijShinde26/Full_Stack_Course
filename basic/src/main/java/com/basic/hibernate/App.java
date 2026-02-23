package com.basic.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

public class App {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        Session session = null;
        Transaction tx = null;

        try {
        	

            // =============================
            // 1️⃣ INSERT DATA
            // =============================
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            User u1 = new User();
            System.out.println("Enter name:");
            String name = in.nextLine();
            u1.setName(name);
            System.out.println("Enter Email: ");
            String email = in.nextLine();
            u1.setEmail(email);

            session.persist(u1);

            tx.commit();
            session.close();

            System.out.println("User Inserted Successfully");


            // =============================
            // 2️⃣ LIST DATA (HQL)
            // =============================
            session = HibernateUtil.getSessionFactory().openSession();

            List<User> list = session
                    .createQuery("FROM User", User.class)
                    .list();

            System.out.println("\nList of Users:");
            for (User u : list) {
                System.out.println(u.getUserId() + " - " + u.getName() + " - " + u.getEmail());
            }

            session.close();


            // =============================
            // 3️⃣ UPDATE USING HQL
            // =============================
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            String updateHql = "UPDATE User SET email = :newEmail WHERE name = :username";

            int updatedRows = session.createQuery(updateHql)
                    .setParameter("newEmail", "updated@gmail.com")
                    .setParameter("username", "Kshitij")
                    .executeUpdate();

            tx.commit();
            session.close();

            System.out.println("\nRows Updated: " + updatedRows);


            // =============================
            // 4️⃣ DELETE USING HQL
            // =============================
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            String deleteHql = "DELETE FROM User WHERE name = :username";

            int deletedRows = session.createQuery(deleteHql)
                    .setParameter("username", "Kshitij")
                    .executeUpdate();

            tx.commit();
            session.close();

            System.out.println("Rows Deleted: " + deletedRows);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
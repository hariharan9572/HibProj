package com.hariharan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       /* Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("Asus");
        l1.setModel("Strix");
        l1.setRam(32);*/


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.hariharan.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

       /* Transaction transaction = session.beginTransaction();
        session.persist(l1);
        transaction.commit();*/

        // select * from laptop where ram = 32; -> SQL
        // from Laptop where ram = 32

        Query query = session.createQuery("from Laptop where ram=32", Laptop.class);
        List<Laptop> laptops = query.getResultList();

        //Laptop l1 = session.get(Laptop.class, 3);

        System.out.println(laptops);

        session.close();

        sf.close();

    }
}
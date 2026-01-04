package com.hariharan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.hariharan.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        //Laptop laptop = session.get(Laptop.class, 2); // @depreciated use find instead of get
        //Laptop laptop = session.find(Laptop.class, 2);

        //Laptop laptop = session.load(Laptop.class, 2); // @depreciated use byId instead of load --> actually load removed in hibernate v7
        Laptop laptop = session.byId(Laptop.class).getReference(2); // Use byId().load() (THIS is the real replacement)
        //System.out.println(laptop);

        session.close();

        sf.close();

    }
}
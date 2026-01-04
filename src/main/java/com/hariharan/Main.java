package com.hariharan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        /*s1.setsName("Navin");
        s1.setRollNo(109);
        s1.setsAge(30);*/

        //Student s2 = null;

        /*Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.hariharan.Student.class);
        cfg.configure();*/

        //SessionFactory sf = cfg.buildSessionFactory();
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.hariharan.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        s1 = session.get(Student.class,109);

        Transaction transaction = session.beginTransaction();

        //session.persist(s1);
        //session.merge(s1);
        session.remove(s1);

        transaction.commit();

        //s2 = session.get(Student.class, 102); @depreciated
        //s2 = session.load(Student.class, 102);
        //s2 = session.find(Student.class, 102);

        session.close();
        sf.close();

        System.out.println(s1);
        //System.out.println(s2);

    }
}
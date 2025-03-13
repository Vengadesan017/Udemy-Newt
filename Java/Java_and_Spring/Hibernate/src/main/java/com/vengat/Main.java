package com.vengat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setRollNo(101);
        s1.setsName("Ramesh");
        s1.setsAge(21);


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.vengat.Student.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // insert
        session.persist(s1);


        // select
        Student s2 = null;
        s2 = session.get(Student.class,106);


        // Update
        Student s3 = new Student();
        s3.setRollNo(105);
        s3.setsName("Rameshupdated");
        s3.setsAge(21);
        session.merge(s3);

        // delete
        session.remove(s2);
        transaction.commit();
        session.close();
        sf.close();


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        ///  embedding
        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);


        Student a1 = new Student();
        a1.setRollNo(101);
        a1.setsName("Navin");
        a1.setLaptop(l1);

//        a1.setLaptop(Arrays.asList(l1,l2));

    }
}

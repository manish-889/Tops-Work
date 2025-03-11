package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Student.class).addAnnotatedClass(Address.class)
        		.buildSessionFactory();
        
        Session s = sf.openSession();
        Transaction tx=s.beginTransaction();
        
        Student st=new Student();
        st.setStudentName("Manoj");
        
        Address ad=new Address();
        ad.setCity("Surat");
        ad.setState("Gujrat");
        ad.setStu(st);
        
        s.save(st);
        s.save(ad);
    
        tx.commit();
        
    }
}

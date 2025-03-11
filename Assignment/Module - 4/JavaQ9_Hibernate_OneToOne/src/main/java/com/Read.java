package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Read {
   
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Student.class).addAnnotatedClass(Address.class)
        		.buildSessionFactory();
		
		Session s=sf.openSession();
		Student st = s.get(Student.class, 2);
		System.out.println(st.getStudentName());
		System.out.println(st.getAddress().getState());
		System.out.println(st.getAddress().getCity());
		
		
	}
	
}

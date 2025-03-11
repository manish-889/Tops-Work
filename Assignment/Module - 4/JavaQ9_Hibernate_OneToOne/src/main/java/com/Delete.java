package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student st = s.get(Student.class, 2);
		s.delete(st);
		tx.commit();
	}
}

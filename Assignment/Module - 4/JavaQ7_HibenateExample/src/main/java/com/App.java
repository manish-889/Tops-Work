package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();
		User user = new User();
		user.setFirstName("Kiran");
		user.setLastName("Thakare");
		user.setEmail("kiran@gmail.com");
		user.setMobile("9876543210");
		user.setPassword("Kiran@1727"); // In production, handle securely!
		user.setGender("Gender");

		s.save(user);
		tx.commit();
	}
}

package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reader.class)
				.addAnnotatedClass(Subscription.class).buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		// Create Readers
		Reader reader1 = new Reader();
		reader1.setEmail("Kiran@example.com");
		reader1.setFirstName("Kiran");
		reader1.setLastName("Thakare");

		Reader reader2 = new Reader();
		reader2.setEmail("Manish@example.com");
		reader2.setFirstName("Manish");
		reader2.setLastName("giri");

		// Create Subscriptions
		Subscription subscription1 = new Subscription();
		subscription1.setSubscriptionName("Monthly Magazine");

		Subscription subscription2 = new Subscription();
		subscription2.setSubscriptionName("Weekly Newsletter");

		// Associate readers with subscriptions
		reader1.addSubscription(subscription1);
		reader1.addSubscription(subscription2);
		reader2.addSubscription(subscription1);

		// Save the readers (and subscriptions automatically due to cascade)
		s.save(reader1);
		s.save(reader2);
		s.save(subscription1);
		s.save(subscription2);

		tx.commit();
	}
}

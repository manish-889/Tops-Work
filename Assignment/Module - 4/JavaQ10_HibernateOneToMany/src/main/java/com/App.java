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

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Item.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Cart cart = new Cart();
		cart.setName("Tv");
		cart.setTotal(0); // Total will be calculated based on added items

		// Create Items and associate with Cart
		Item item1 = new Item();
		item1.setItemId("123");
		item1.setItemTotal(2400.0);
		item1.setQuantity(10);

		Item item2 = new Item();
		item2.setItemId("467");
		item2.setItemTotal(5400.0);
		item2.setQuantity(9);

		// Add items to cart
		cart.addItem(item1);
		cart.addItem(item2);

		// Save the cart
		s.save(cart);
		tx.commit();

	}
}

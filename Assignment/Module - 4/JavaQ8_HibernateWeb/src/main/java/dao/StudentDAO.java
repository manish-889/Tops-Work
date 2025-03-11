package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class StudentDAO {

	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class).buildSessionFactory();

	public void saveStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	}

	public Student getStudent(String email, String password) {
		Session session = sessionFactory.openSession();
		Student student = session
				.createQuery("FROM Student WHERE email = :email AND password = :password", Student.class)
				.setParameter("email", email).setParameter("password", password).uniqueResult();
		session.close();
		return student;
	}

	public void updateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(student);
		tx.commit();
		session.close();
	}
}

package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			session.beginTransaction();

			Student student = session.get(Student.class, studentId);

			System.out.println("Updating student");
			student.setFirstName("Bo");

			session.getTransaction().commit();

			// update using query
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update all student");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception e) {
			factory.close();
		}
	}

}

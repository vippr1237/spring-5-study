package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Huy", "Trinh", "huytinh@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the student");
			session.save(tempStudent);
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception e) {
			factory.close();
		}
	}

}

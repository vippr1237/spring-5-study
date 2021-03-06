package com.ifisolution.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> list = session.createQuery("from Student").getResultList();

			displayStudents(list);

			list = session.createQuery("from Student s where s.lastName = 'Trinh'").getResultList();

			System.out.println("Student last name is Trinh");
			displayStudents(list);

			list = session.createQuery("from Student s where" + " s.lastName='Trinh' OR s.firstName='Minh'")
					.getResultList();
			System.out.println("Student last name is Trinh or first name is Minh");
			displayStudents(list);

			list = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com'").getResultList();

			System.out.println("Student has email like gmail.com");
			displayStudents(list);
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception e) {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}
	}

}

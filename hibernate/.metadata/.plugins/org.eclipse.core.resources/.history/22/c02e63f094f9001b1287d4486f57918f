package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			session.beginTransaction();

//			Student student = session.get(Student.class, studentId);
//
//			System.out.println("Delete student " + student);
//			session.delete(student);
//
//			session.getTransaction().commit();

			// delete using query
			System.out.println("Delete Student id=2");

			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception e) {
			factory.close();
		}
	}

}

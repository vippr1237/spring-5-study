package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Course;
import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			int theId = 12;

			Course course = session.get(Course.class, theId);

			System.out.println("Deleting course: " + course);
			session.delete(course);
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}

package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Course;
import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int theId = 2;
			Instructor instructor = session.get(Instructor.class, theId);

			Course course1 = new Course("Ckam cam va anime");
			Course course2 = new Course("Bong ro");

			instructor.add(course1);
			instructor.add(course2);

			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}

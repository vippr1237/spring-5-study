package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Course;
import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;
import com.ifisolution.demo.entity.Review;
import com.ifisolution.demo.entity.Student;

public class AddCourseForHuyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int theId = 1;
			Student student = session.get(Student.class, theId);

			System.out.println("The student: " + student);

			Course course1 = new Course("Jump squat like a pro");
			Course course2 = new Course("Hand stand like a pro");

			course1.addStudent(student);
			course2.addStudent(student);

			System.out.println("Saving course");

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

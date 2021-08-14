package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ifisolution.demo.entity.Course;
import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			int theId = 2;
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id = :instructorId",
					Instructor.class);
			query.setParameter("instructorId", theId);

			Instructor instructor = query.getSingleResult();

			System.out.println("Instructor: " + instructor);

			session.getTransaction().commit();
			session.close();
			System.out.println("Courses: " + instructor.getCourses());

			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}

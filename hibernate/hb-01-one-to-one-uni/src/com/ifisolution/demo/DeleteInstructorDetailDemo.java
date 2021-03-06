package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int theId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			System.out.println("instructor detail:" + instructorDetail);
			instructorDetail.getInstructor().setInstructorDetail(null);
			if (instructorDetail != null) {
				session.delete(instructorDetail);
			}

			System.out.println("the associated instructor: " + instructorDetail.getInstructor());
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Instructor instructor = new Instructor("Coang", "Ha", "coangha@gmai.com");

			InstructorDetail instructorDetail = new InstructorDetail("San bong ro ckam cam va anime", "Ballizlife");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();

			System.out.println("Saving instructor: " + instructor);
			// save instruct detail at same time due to cascade
			session.save(instructor);
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}

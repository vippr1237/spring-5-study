package com.ifisolution.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ifisolution.demo.entity.Course;
import com.ifisolution.demo.entity.Instructor;
import com.ifisolution.demo.entity.InstructorDetail;
import com.ifisolution.demo.entity.Review;
import com.ifisolution.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			Course course = new Course("Ckam cam va anime va bong' ro");

			System.out.println("Saving course");
			session.save(course);

			System.out.println("Save the course " + course);

			Student student1 = new Student("huy", "trinh", "huytrinh@gmail.com");
			Student student2 = new Student("coang", "ha", "coangha@gmail.com");

			System.out.println("Save student");
			course.addStudent(student1);
			course.addStudent(student2);
			session.save(student1);
			session.save(student2);
			System.out.println("Saved student: " + course.getStudents());
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}

package com.trinh.hibernate.demo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trinh.hibernate.demo.entity.Course;
import com.trinh.hibernate.demo.entity.Instructor;
import com.trinh.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory from configuration file
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
			Instructor tempInstructor = new Instructor("Trinh", "Dinh", "Trinh@email.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://trinh.channel", "Valor");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// save
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit
			session.getTransaction().commit();

			System.out.println("Complete");

		} finally {
			factory.close();
		}

	}

}

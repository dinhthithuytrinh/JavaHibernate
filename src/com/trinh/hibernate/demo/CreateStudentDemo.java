package com.trinh.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trinh.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		// Create session factory from configuration file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student
			System.out.println("Create a student");
			// Student tempStudent = new Student("Trinh", "Dinh", "trinh@gmail.com");
			// Student tempStudent2 = new Student("Trinh2", "Dinh2", "trinh2@gmail.com");
			// Student tempStudent3 = new Student("Trinh3", "Dinh3", "trinh3@gmail.com");
			// Student tempStudent4 = new Student("Trinh4", "Dinh4", "trinh4@gmail.com");
			// Student tempStudent5 = new Student("Trinh5", "Dinh5", "trinh5@gmail.com");
			Student tempStudent5 = new Student("Trinh5", "Dinh5", "trinh5@gmail.com",
					DateUtils.parseDate("15/05/1995"));

			// start transaction
			session.beginTransaction();

			// save object
			System.out.println("Saving the student");
			// session.save(tempStudent);
			// session.save(tempStudent2);
			// session.save(tempStudent3);
			// session.save(tempStudent4);
			// session.save(tempStudent5);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Complete");
		} finally {
			factory.close();
		}

	}

}

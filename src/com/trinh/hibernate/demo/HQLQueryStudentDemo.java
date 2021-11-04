package com.trinh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trinh.hibernate.demo.entity.Student;

public class HQLQueryStudentDemo {

	public static void main(String[] args) {

		// create session factory from configuration file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// retrieve all Student object to List
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			System.out.println("\n\nStudent with firstName='Trinh'");
			theStudents = session.createQuery("from Student s where s.firstName='Trinh'").getResultList();

			displayStudents(theStudents);

			System.out.println("\n\nStudent with firstName='Ray' OR firstName='Mei'");
			theStudents = session.createQuery("from Student s where s.firstName='Trinh' or s.firstName='Mei'")
					.getResultList();
			displayStudents(theStudents);

			System.out.println("\n\nStudent with firstName LIKE '%trinh%' ");
			theStudents = session.createQuery("from Student s where s.firstName LIKE '%trinh%'").getResultList();
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Complete");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

}

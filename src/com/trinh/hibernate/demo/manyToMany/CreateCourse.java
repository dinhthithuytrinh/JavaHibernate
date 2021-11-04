package com.trinh.hibernate.demo.manyToMany;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trinh.hibernate.demo.DateUtils;
import com.trinh.hibernate.demo.entity.Course;
import com.trinh.hibernate.demo.entity.Instructor;
import com.trinh.hibernate.demo.entity.InstructorDetail;
import com.trinh.hibernate.demo.entity.Student;

public class CreateCourse {

	public static void main(String[] args) throws ParseException {
		// create session factory from configuration file
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// create course
			Course tempCourse = new Course("Java");

			// create student
			Student tempStudent3 = new Student("May", "Dinh", "may@email.com", DateUtils.parseDate("20/09/2021"));
			Student tempStudent4 = new Student("Maya", "Oosaku", "Trinh3@email.com", DateUtils.parseDate("20/09/2021"));

			List<Student> listStudent = new ArrayList();
			listStudent.add(tempStudent3);
			listStudent.add(tempStudent4);

			tempCourse.setStudents(listStudent);

			// save
			session.save(tempCourse);
			session.save(tempStudent3);
			session.save(tempStudent4);
			System.out.println("Save completed");

			// commit
			session.getTransaction().commit();

			System.out.println("Complete");

		} finally {
			factory.close();
		}

	}

}

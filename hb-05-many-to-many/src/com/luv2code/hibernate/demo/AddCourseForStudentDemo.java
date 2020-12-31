package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForStudentDemo {

	public static void main(String[] args) {
		
		//Crea la sesion
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//Obtiene la sesion actual
		Session session = factory.getCurrentSession();
		
		try {
			//Inicia la transaccion
			session.beginTransaction();
			int theId = 1;
			
			Student tempStudent = session.get(Student.class, theId);
			
			Course tempCourse1 = new Course("Quick Rubic Build - just 4 seconds!!!");
			Course tempCourse2 = new Course("Advance Matematic");
			Course tempCourse3 = new Course("Cinema Apretiation");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
			System.out.println("Saving courses");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			//Confirma los cambios en base de datos
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		} finally  {
			factory.close();
		}
	}

}

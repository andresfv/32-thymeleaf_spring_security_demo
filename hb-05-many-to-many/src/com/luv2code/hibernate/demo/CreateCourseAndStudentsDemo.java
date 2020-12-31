package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			Course tempCourse = new Course("VideoGames Desing");
			
			session.save(tempCourse);
			 
			Student tempStudent1 = new Student("Eva", "Valenciano", "evalenciano@gmail");
			Student tempStudent2 = new Student("Martin", "Valenciano", "mvalenciano@gmail");
			Student tempStudent3 = new Student("Sara", "Valenciano", "svalenciano@gmail");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			
			//Confirma los cambios en base de datos
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		} finally  {
			factory.close();
		}
	}

}

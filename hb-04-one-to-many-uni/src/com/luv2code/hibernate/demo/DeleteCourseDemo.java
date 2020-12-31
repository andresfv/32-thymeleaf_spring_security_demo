package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//Crea la sesion
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		//Obtiene la sesion actual
		Session session = factory.getCurrentSession();
		
		try {
			//Inicia la transaccion
			session.beginTransaction();
		
			int theId = 11;
			Course tempCourse = session.get(Course.class, theId);
			
			session.delete(tempCourse);
			
			//Confirma los cambios en base de datos
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		} finally  {
			factory.close();
		}
	}

}

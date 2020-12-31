package com.luv2code.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStundentDemo {

	public static void main(String[] args) {
		
		//Crea la sesion
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//Obtiene la sesion actual
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("READING STUDENT OBJECT...");
			
			//Inicia la transaccion
			session.beginTransaction();
			
			System.out.println("GETTING STUDENT WITH LAST NAME EQUAL FALLAS");
			
			List<Student> theStudents = session.createQuery("from Student where first_name = 'Isaac'").getResultList();
			
			displayStudents(theStudents);
		
			session.getTransaction().commit();
			
		} finally  {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

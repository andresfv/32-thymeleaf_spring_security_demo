package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStundentDemo {

	public static void main(String[] args) {
		
		//Crea la sesion
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//Obtiene la sesion actual
		Session session = factory.getCurrentSession();
		
		try {
			//Crea el objeto, en este caso para efectos de practica
			System.out.println("CREATING STUDENT OBJECT...");
			Student tempStudent = new Student ("Isaac", "Fallas", "andresfallas@gmail.com");
			
			//Inicia la transaccion
			session.beginTransaction();
			
			//Salva el objeto en base de datos
			session.save(tempStudent);
			System.out.println("SAVING THE STUDENT...");
			
			//Confirma los cambios en base de datos
			session.getTransaction().commit();
			
			System.out.println("STUDENT SAVED!!!");
		} finally  {
			factory.close();
		}
	}

}

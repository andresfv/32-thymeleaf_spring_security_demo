package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
	//Crea la sesion
	SessionFactory factory = new Configuration()
							 .configure("hibernate.cfg.xml")
							 .addAnnotatedClass(Instructor.class)
							 .addAnnotatedClass(InstructorDetail.class)
							 .buildSessionFactory();
	
	//Obtiene la sesion actual
	Session session = factory.getCurrentSession();
	
	try {
	
		//Inicia la transaccion
		session.beginTransaction();
		
	    //Busca el instructor por borrar
		Instructor tempInstructor = session.get(Instructor.class, 2);
		System.out.println("Borrando Instructor " + tempInstructor);
		
		//Elimina el instructor de la base de datos
		//Esto tambien eliminara el objeto instructorDetail debido a la configuracion cascade.ALL
		if (tempInstructor!=null) {
			System.out.println("Borrando");
			session.delete(tempInstructor);
		}
		
		//Confirma los cambios en base de datos
		session.getTransaction().commit();
		
		System.out.println("DELETED!!!");
	} finally  {
		factory.close();
	}
}
}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			//Crea los objetos
			Instructor tempInstructor = new Instructor("Jose", "Rayo", "jrayoz@una");
			InstructorDetail tempInstructorDetail = new InstructorDetail("jrayo/youtube", "Sell");
			
			
			//Asocia objetos
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Inicia la transaccion
			session.beginTransaction();
			
			//Salva el instructor a la base de datos
			//Esto tambien salvara el objeto instructorDetail debido a la configuracion cascade.ALL
			session.save(tempInstructor);
			System.out.println("Salvando Instructor " + tempInstructor);
			
			//Confirma los cambios en base de datos
			session.getTransaction().commit();
			
			System.out.println("SAVED!!!");
		} finally  {
			factory.close();
		}
	}

}

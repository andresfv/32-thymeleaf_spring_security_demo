package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
		
		int theId = 5;
		
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
		if (tempInstructorDetail!=null) {
			System.out.println("Instructor Detail found!!: "+ tempInstructorDetail);
			System.out.println("The instructor asociated is "+tempInstructorDetail.getInstructor());
			
			//Ejemplo cuando solo se desea eliminar el detalle sin tocar el instructor
			//Es necesario limpiar toda asociacion entre los objetos para evitar irregularidades en los datos
			Instructor tempInstructor = tempInstructorDetail.getInstructor();
			tempInstructor.setInstructorDetail(null);
			
			//Elimina el instructor desde el instructorDetail
			session.delete(tempInstructorDetail);
		}else {
			System.out.println("Intructor not found!!!");
		}
		
		//Confirma los cambios en base de datos
		session.getTransaction().commit();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	finally  {
		session.close();
		factory.close();
	}
}
}

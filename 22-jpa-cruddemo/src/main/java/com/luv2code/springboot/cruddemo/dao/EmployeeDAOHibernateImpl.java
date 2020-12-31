package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

//	Define field for EntityManager
	private EntityManager entityManager;

//	Set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
//		get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

//		Create a query native hql
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

//		Execute the query to get the results
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
//		get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

//		Get the employee by Id
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
//		get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

//		Save or update an Employee depending on its ID value (null = save / notNull= update)
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
//		get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

//		Create a query native hql to delete
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}

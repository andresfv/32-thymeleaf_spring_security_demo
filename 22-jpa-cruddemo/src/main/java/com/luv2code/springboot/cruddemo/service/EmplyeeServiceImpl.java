package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;

	//Se uso @Qualifier para elegir una implementación ya que en este caso existen más de uno
	@Autowired
	public EmplyeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}

}

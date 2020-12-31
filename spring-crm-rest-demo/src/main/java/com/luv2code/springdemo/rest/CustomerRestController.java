package com.luv2code.springdemo.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * Busca todos los customers
	 * @return Lista de Customers
	 */
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	
	/**
	 * Busca un customer por ID
	 * @param customerId
	 * @return Costumer encontrado por ID
	 */
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - "+customerId);
		}
		return theCustomer;
	}
	
	/**
	 * Añade un nuevo customer via Json
	 * @param theCustomer
	 * @return Nuevo Customer
	 */
	@PostMapping("/customers")
	public Customer addCutomer (@RequestBody Customer theCustomer) {
		
		//Se setea a 0 para forzar el guardado de un nuevo item en vez de actualizar
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	/**
	 * Actualiza un customer
	 * @param theCustomer
	 * @return Customer actualizado
	 */
	@PutMapping("/customers")
	public Customer updateCutomer (@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		//Throw exception si no encuentra el resultado
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - "  + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Delete customer id - " + customerId;
	}
}

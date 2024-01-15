package neu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import neu.edu.controller.model.Customer;
import neu.edu.entity.Customers;

import neu.edu.repository.CustomerRepository;

@Service
public class CustomerService {

	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private CustomerRepository customerReopsitory;
	public boolean saveUser(Customer customer) {
		Customers customers = new Customers();
		customers.setFirstName(customer.getFirstName());
		customers.setLastName(customer.getLastName());
		customers.setPassword(customer.getPassword());
		customers.setUsername(customer.getUsername());
		customers.setAddress(customer.getAddress());
		customers.setEmail(customer.getEmail());
		
		System.out.println("inserted ser");
		return customerReopsitory.save(customers);
	}
	public Customers   findCustomer(String username)
	{
		return customerReopsitory.findByUserName(username);
	}

}

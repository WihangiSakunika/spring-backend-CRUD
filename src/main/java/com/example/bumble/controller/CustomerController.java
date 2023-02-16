package com.example.bumble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bumble.exception.ResourceNotFoundException;
import com.example.bumble.model.Customer;
import com.example.bumble.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
	@Autowired
  private CustomerRepository cutomerRepository;
	//get all customers
	@GetMapping("/customers")
	public List<Customer>getAllCustomers(){
		//return customerrepository.finalAll();
		return cutomerRepository.findAll();
	}
	//create customer rest API
	@PostMapping("/customers")
	public Customer CreateCustomer(@RequestBody Customer customer) {return cutomerRepository.save(customer); }
	//get customer by id rest API
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer>getCustomerById(@PathVariable Long id){
		Customer customer = cutomerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not exits with id : "+id));
		return ResponseEntity.ok(customer);
	}
}

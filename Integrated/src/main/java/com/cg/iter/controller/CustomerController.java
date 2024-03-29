package com.cg.iter.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.dao.CustomerRepository;
import com.cg.iter.entity.Admin;
import com.cg.iter.entity.Customer;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.service.CustomerService;

@RestController
@RequestMapping("/usr")
@CrossOrigin(value = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerRepository dao;

	// SHOW ALL CUSTOMERS
	@GetMapping("/getUser")
	public List<Customer> getAllCustomer() {
		return dao.findAll();
	}

	// SEARCH CUSTOMER
	@RequestMapping("/getUser/{id}")
	public ResponseEntity<Customer> findProduct1(@PathVariable("id") int uid) {
		Optional<Customer> findById = dao.findById(uid);
		if (findById.isPresent()) {
			Customer usr = findById.get();
			return new ResponseEntity<Customer>(usr, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

	}

	// Add CUSTOMER
	@PostMapping("/getUser")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return dao.save(customer);
	}

	/*
	 * @ExceptionHandler(RecordNotFoundException.class) public
	 * ResponseEntity<Customer> addUser(@RequestBody Customer usr) {
	 * Optional<Customer> findById = dao.findById(usr.getId()); try { if
	 * (!findById.isPresent()) { dao.save(usr); return new
	 * ResponseEntity<Customer>(usr, HttpStatus.OK); } else throw new
	 * RecordNotFoundException("Record Already Present!!"); } catch
	 * (RecordNotFoundException e) { return new ResponseEntity(e.getMessage(),
	 * HttpStatus.NOT_FOUND); } }	
	 */

	// DELETE CUSTOMER
	@DeleteMapping("/getUser/{id}")
	public String removeCustomer(@PathVariable("id") int uid) {
		Optional<Customer> findById = dao.findById(uid);
		if (findById.isPresent()) {
			dao.deleteById(uid);
			return "Customer " + dao.findById(uid) + " Removed!!!";
		}
		return "Customer Not Found!!!";
	}

	// COUNT CUSTOMER
	@GetMapping("/getCount")
	public String getCount() {
		return "Total No. of Records are : " + dao.count();
	}

	// UPDATE CUSTOMER
	@PutMapping("/getUser/")
	public ResponseEntity<Customer> updateProduct(@Valid @RequestBody Customer customer) {

		Optional<Customer> findById = dao.findById(customer.getId());
		try {
			if (findById.isPresent()) {
				dao.save(customer);
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			} else {
				throw new RecordNotFoundException("Record not present");
			}
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	

}

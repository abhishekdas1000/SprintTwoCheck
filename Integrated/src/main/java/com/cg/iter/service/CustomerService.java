package com.cg.iter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.dao.CustomerRepository;

@Service("customerService")
public class CustomerService {
	@Autowired
	private CustomerRepository customerdao;
	
	
}

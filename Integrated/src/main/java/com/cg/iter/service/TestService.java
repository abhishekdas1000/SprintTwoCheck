package com.cg.iter.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.entity.Test;

public interface TestService {

	public List<Test> getAllTests();
	public ResponseEntity<?> findTest(Integer tid);
	public Test saveTest(Test test);
	public String removeTest(Integer tid);
	public ResponseEntity<Test> updateTest(Test test);
	
}

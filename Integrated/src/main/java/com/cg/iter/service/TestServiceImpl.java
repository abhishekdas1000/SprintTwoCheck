package com.cg.iter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.iter.dao.TestRepositories;
import com.cg.iter.entity.Test;
import com.cg.iter.exception.RecordNotFoundException;
@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestRepositories dao;
	
	@Override
	public ResponseEntity<?> findTest(Integer tid) {
		Optional<Test> findById=dao.findById(tid);
		try {
			if(findById.isPresent()) {
				Test test=findById.get();
				return new ResponseEntity<Test>(test,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Test not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Test saveTest(Test test) {
		return  dao.save(test);
	}

	@Override
	public String removeTest(Integer tid) {
		Optional<Test> findById=dao.findById(tid);
		if(findById.isPresent()) {
			dao.deleteById(tid);
			return "Test removed";
		}
		return "Test not present";
	}

	@Override
	public ResponseEntity<Test> updateTest(Test test) {
		 Optional<Test> findById = dao.findById(test.getTestId());
	        try {
	            if (findById.isPresent()) {
	                dao.save(test);
	                return new ResponseEntity<Test>(test, HttpStatus.OK);
	            	} 
	            else {
	                throw new RecordNotFoundException("Test not present");
	            }
	        }
	        catch (RecordNotFoundException e) {
	            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	}

	@Override
	public List<Test> getAllTests() {
		return dao.findAll();
	}

}

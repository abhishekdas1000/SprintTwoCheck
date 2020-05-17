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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.dao.TestRepositories;
import com.cg.iter.entity.Appointment;
import com.cg.iter.entity.Test;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.service.TestService;

@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class TestController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/allTests")
	public List<Test> getAllTests(){
		return testService.getAllTests();
		}
	
	@RequestMapping("/searchTest/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findTest(@PathVariable("id") Integer tid) {
		return testService.findTest(tid);
	}
	
//	@PostMapping("/addTest")
//	@ExceptionHandler(RecordNotFoundException.class)
//		public ResponseEntity<Test> saveTest(@RequestBody Test test) {
//		Optional<Test> findById=dao.findById(test.getTestId());
//		try{
//			if(!findById.isPresent()) {
//				dao.save(test);
//				return new ResponseEntity<Test>(test, HttpStatus.OK);
//			}
//			else
//				throw new RecordNotFoundException("Test already present...");
//		}
//		catch(RecordNotFoundException e){
//			return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND);
//		}
//	}
	
	@PostMapping("/addTest")
    public Test saveTest(@Valid @RequestBody Test test) {
            return  testService.saveTest(test);
    }
	
	@DeleteMapping("/deleteTest/{id}")
	public String removeTest(@PathVariable("id") Integer tid) {
		return testService.removeTest(tid);
	}
	
	@PutMapping("/updateTest")
    public ResponseEntity<Test> updateTest(@Valid @RequestBody Test test) {
		return testService.updateTest(test);
    }
	
//	@PutMapping("/updateTest")
//	public String updateTest(@RequestBody Test test) {
//		Optional<Test> findById=dao.findById(test.getTestId());
//		if(findById.isPresent()) {
//			dao.save(test);
//			return "Test updated";
//		}
//		return "Test not present";
//	}

}

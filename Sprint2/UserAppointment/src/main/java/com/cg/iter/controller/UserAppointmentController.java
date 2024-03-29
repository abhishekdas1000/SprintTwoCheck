package com.cg.iter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.iter.entity.Appointment;
import com.cg.iter.entity.DiagnosticCentre;
import com.cg.iter.entity.Test;
import com.cg.iter.exception.DuplicateUserIdException;
import com.cg.iter.service.UserAppointmentService;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:4200")
public class UserAppointmentController {

	@Autowired
	UserAppointmentService userAppointmnetS;

	@GetMapping("/FetchCenterList")
	public List<DiagnosticCentre> getCenterList() {
		List<DiagnosticCentre> center = userAppointmnetS.DiagnosticCenterList();
		return center;
	}

	@GetMapping("/FetchTestList/{centerId}")
	public List<Test> getTestList(@PathVariable("centerId") String centerId) {
		List<Test> dCenter = userAppointmnetS.TestsList(centerId);
		return dCenter;
	}

	@PostMapping("/makeAppointment")
	public ResponseEntity<Boolean> updateAppointment(@RequestBody Appointment app) {
		Boolean exists = userAppointmnetS.userIdFound(app.getUserId());
		if (exists) {
			System.out.println(exists);
			userAppointmnetS.makeAppointment(app);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			throw new DuplicateUserIdException("Sorry! User Id exists");
		}
	}

	@ExceptionHandler(DuplicateUserIdException.class)
	public ResponseEntity<Boolean> userFound(DuplicateUserIdException e) {
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
}


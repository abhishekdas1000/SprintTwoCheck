package com.cg.iter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.entity.Appointment;
import com.cg.iter.service.AdminViewService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("http://localhost:4200")
public class ApproveAppointmentsController {
	@Autowired    // service interface object
	AdminViewService adminViewService;
	
	 @PutMapping("/approveAppointment")
	 public String updateAppointment(@RequestBody Appointment app) {
		 System.out.println(app.toString());
		 String updateMsg =  adminViewService.approveAppointment(app);
		 return updateMsg;
	 }
}

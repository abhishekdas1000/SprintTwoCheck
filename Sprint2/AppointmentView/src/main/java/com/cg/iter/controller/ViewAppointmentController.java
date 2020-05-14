package com.cg.iter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.entity.Appointment;
import com.cg.iter.service.UserViewService;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:4200")
public class ViewAppointmentController {
	
	@Autowired    // service interface object
	UserViewService userAppointmnetS;
	
	 @GetMapping("/FetchAppList") // displaying all values in appointment table
	   public List<Appointment> getCenterList(){
		   List<Appointment> center=userAppointmnetS.AppointmentList();
		   return center; 
	   }

}


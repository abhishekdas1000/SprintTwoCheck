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

import com.cg.iter.dao.AppointmentRepositories;
import com.cg.iter.entity.Appointment;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.service.AppointmentService;

@RestController
@RequestMapping("/appoint")
@CrossOrigin("http://localhost:4200")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping("/allAppointments")
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	@RequestMapping("/searchAppointment/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findAppointment1(@PathVariable("id") int appointmentid) {
		return appointmentService.findAppointment1(appointmentid);
	}
	
//	@RequestMapping("/searchAppointment/{id}")
//	public Appointment findAppointment(@PathVariable("id") int appointmentid) {
//		Optional<Appointment> findById=dao.findById(appointmentid);
//		if(findById.isPresent())
//			return findById.get();
//		
//		return null;
//	}
	
//	@PostMapping("/addAppointment")
//	public String saveAppointment(@RequestBody Appointment appointment1) {
//		Optional<Appointment> findById=dao.findById(appointment1.getAppointmentId());
//		if(!findById.isPresent()) {
//			dao.save(appointment1);
//			return "appointment added";
//		}
//		
//		return "appointment already exists";
//	}
	
	@PostMapping("/addAppointment")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> saveAppointment2(@RequestBody Appointment appointment2) {
		return appointmentService.saveAppointment2(appointment2);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public String removeAppointment(@PathVariable("id") int appointmentid) {
		return appointmentService.removeAppointment(appointmentid);
	}
	
	@PutMapping("/updateAppointment")
    public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appoint) {
		return appointmentService.updateAppointment(appoint);
    }
	
//	@PutMapping("/updateAppointment")
//	public String updateAppointment(@RequestBody Appointment appointment) {
//		Optional<Appointment> findById=dao.findById(appointment.getAppointmentId());
//		if(findById.isPresent()) {
//			dao.save(appointment);
//			return "Appointment updated";
//		}
//		
//		return "Appointment not present";
//	}

}

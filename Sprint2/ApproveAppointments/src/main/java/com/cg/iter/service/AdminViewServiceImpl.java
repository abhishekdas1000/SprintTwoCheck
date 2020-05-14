package com.cg.iter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.repositories.AppointmentRepository;
import com.cg.iter.entity.Appointment;
@Service
public class AdminViewServiceImpl implements AdminViewService{
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appList=appointmentRepository.findAll(); 
		// using data jpa find all method to get the values
		return appList;
	}

	@Override
	public String approveAppointment(Appointment app) {
		Appointment updatedApp= appointmentRepository.save(app);
		return "Appointment is updated";
	}


}
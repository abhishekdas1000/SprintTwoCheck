package com.cg.iter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.repositories.AppointmentRepository;
import com.cg.iter.repositories.CentreRepository;
import com.cg.iter.repositories.TestRepository;
import com.cg.iter.entity.Appointment;
import com.cg.iter.entity.DiagnosticCentre;
import com.cg.iter.entity.Test;
@Service
public class UserAppointmentServiceImpl implements UserAppointmentService  {

	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	CentreRepository centerListRepository;
	
	@Override
	public List<DiagnosticCentre> DiagnosticCenterList() {
		List<DiagnosticCentre> CenterList=centerListRepository.findAll();
		return CenterList;
	}

	
	@Override
	public List<Test> TestsList(String centreId) {
		List<Test> testList=centerListRepository.getOne(centreId).getListOfTests();
		return testList;
	}
	
	public Boolean userIdFound(String userId){
		List<String> exists=appointmentRepository.checkUserIdEXists(userId);
		Boolean value=exists.isEmpty();
	return value;
	}

	@Override
	public String makeAppointment(Appointment app) {
		Appointment updatedApp= appointmentRepository.save(app);
		
		return "Appointment is registered, please await for confirmation";
	}


	}



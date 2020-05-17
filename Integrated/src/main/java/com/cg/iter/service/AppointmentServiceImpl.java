package com.cg.iter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.iter.dao.AppointmentRepositories;
import com.cg.iter.entity.Appointment;
import com.cg.iter.exception.RecordNotFoundException;

public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepositories dao;
	
	@Override
	public List<Appointment> getAllAppointments() {
		return dao.findAll();
	}

	@Override
	public ResponseEntity<?> findAppointment1(int appointmentid) {
		Optional<Appointment> findById=dao.findById(appointmentid);
		try {
			if(findById.isPresent()) {
				Appointment appointment=findById.get();
				return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Appointment> saveAppointment2(Appointment appointment2) {
		Optional<Appointment> findById=dao.findById(appointment2.getAppointmentId());
		try{
			if(!findById.isPresent()) {
				dao.save(appointment2);
				return new ResponseEntity<Appointment>(appointment2, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<Appointment>(appointment2, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String removeAppointment(int appointmentid) {
		Optional<Appointment> findById=dao.findById(appointmentid);
		if(findById.isPresent()) {
			dao.deleteById(appointmentid);
			return "Appointment removed";
		}
		
		return "Appointment not present";
	}

	@Override
	public ResponseEntity<Appointment> updateAppointment(Appointment appoint) {
        Optional<Appointment> findById = dao.findById(appoint.getAppointmentId());
        try {
            if (findById.isPresent()) {
                dao.save(appoint);
                return new ResponseEntity<Appointment>(appoint, HttpStatus.OK);
            	} 
            else {
                throw new RecordNotFoundException("Appointment not present");
            }
        }
        catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}

}

package com.cg.iter.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.cg.iter.entity.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointments();
	public ResponseEntity<?> findAppointment1(int appointmentid);
	public ResponseEntity<Appointment> saveAppointment2(Appointment appointment2);
	public String removeAppointment(int appointmentid);
	public ResponseEntity<Appointment> updateAppointment(Appointment appoint);
	
}

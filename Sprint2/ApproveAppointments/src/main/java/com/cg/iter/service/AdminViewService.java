package com.cg.iter.service;

import java.util.List;

import com.cg.iter.entity.Appointment;

public interface AdminViewService {
	List<Appointment> AppointmentList();

	String approveAppointment(Appointment app);

}


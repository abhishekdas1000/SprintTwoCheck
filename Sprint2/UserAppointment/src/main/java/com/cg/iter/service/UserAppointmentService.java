package com.cg.iter.service;


import java.util.List;

import com.cg.iter.entity.Appointment;
import com.cg.iter.entity.DiagnosticCentre;
import com.cg.iter.entity.Test;


public interface UserAppointmentService {
	List<DiagnosticCentre> DiagnosticCenterList();
	List<Test> TestsList(String centreId);
	String makeAppointment(Appointment app);
    Boolean userIdFound(String userId);

}


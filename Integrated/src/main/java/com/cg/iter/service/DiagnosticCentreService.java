package com.cg.iter.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.entity.DiagnosticCentre;

public interface DiagnosticCentreService {

	
	
	public List<DiagnosticCentre> getAllDiagnosticCentres();
	
	public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(DiagnosticCentre diagnosticCentre2);
	
	public String removeDiagnosticCentre(String centreid);
	
	 public ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(DiagnosticCentre diagnosticCentre);
	 
	 public ResponseEntity<DiagnosticCentre> findDiagnosticCentre1(String centreid);
}

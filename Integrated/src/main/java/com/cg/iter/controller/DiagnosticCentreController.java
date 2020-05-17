package com.cg.iter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.iter.entity.DiagnosticCentre;
import com.cg.iter.exception.RecordNotFoundException;
import com.cg.iter.service.DiagnosticCentreService;

@RestController
@RequestMapping("/diagnosticCentre")
@CrossOrigin("http://localhost:4200")
public class DiagnosticCentreController {
	
	@Autowired
	DiagnosticCentreService diagnosticCentreService;
	
	@RequestMapping("/allDiagnosticCentres")
	public List<DiagnosticCentre> getAllDiagnosticCentres(){
		return diagnosticCentreService.getAllDiagnosticCentres();
	}
	
	@RequestMapping("/searchDiagnosticCentre/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findDiagnosticCentre1(@PathVariable("id") String centreid) {
	return	diagnosticCentreService.findDiagnosticCentre1(centreid);
		}
	
	
//	@RequestMapping("/searchDiagnosticCentre/{id}")
//	public DiagnosticCentre findDiagnosticCentre(@PathVariable("id") int diagnosticCentreid) {
//		Optional<DiagnosticCentre> findById=dao.findById(diagnosticCentreid);
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
	
	@PostMapping("/addDiagnosticCentre")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(@RequestBody DiagnosticCentre diagnosticCentre2) {
		return diagnosticCentreService.saveDiagnosticCentre(diagnosticCentre2);
	}
	
	@DeleteMapping("/deleteDiagnosticCentre/{id}")
	public String removeDiagnosticCentre(@PathVariable("id") String centreid) {
		return diagnosticCentreService.removeDiagnosticCentre(centreid);
	}
	
	@PutMapping("/updateDiagnosticCentre")
	@ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(@Valid @RequestBody DiagnosticCentre diagnosticCentre) {

   return diagnosticCentreService.updateDiagnosticCentre(diagnosticCentre);
    }
	
//	@PutMapping("/updateDiagnosticCentre")
//	public String updateDiagnosticCentre(@RequestBody DiagnosticCentre diagnosticCentre) {
//		Optional<DiagnosticCentre> findById=dao.findById(diagnosticCentre.getDiagnosticCentreId());
//		if(findById.isPresent()) {
//			dao.save(diagnosticCentre);
//			return "Diagnostic Centre updated";
//		}
//		
//		return "Diagnostic Centre not present";
//	}

}

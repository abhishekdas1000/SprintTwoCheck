package com.cg.iter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.iter.dao.DiagnosticCentreRepositories;
import com.cg.iter.entity.DiagnosticCentre;
import com.cg.iter.exception.RecordNotFoundException;
@Service
public class DiagnosticCentreServiceImpl implements DiagnosticCentreService {
    @Autowired
	DiagnosticCentreRepositories diagnosticCentrerepo;
	@Override
	public List<DiagnosticCentre> getAllDiagnosticCentres() {
		
	return	diagnosticCentrerepo.findAll();
		
		
	}

	@Override
	public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(DiagnosticCentre diagnosticCentre2) {
		String centre_Id="CEN"+diagnosticCentrerepo.count();
		diagnosticCentre2.setcentreId(centre_Id);

		
		Optional<DiagnosticCentre> findCentre=diagnosticCentrerepo.findById(diagnosticCentre2.getcentreId());
		try{
			if(!findCentre.isPresent()) {
		diagnosticCentrerepo.save(diagnosticCentre2);
		return new ResponseEntity<DiagnosticCentre>(diagnosticCentre2, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Diagnostic Centre is already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<DiagnosticCentre>(diagnosticCentre2, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String removeDiagnosticCentre(String centreid) {

		
		Optional<DiagnosticCentre> findCentre=diagnosticCentrerepo.findById(centreid);
		
		if(findCentre.isPresent())
		{
		diagnosticCentrerepo.deleteById(centreid);
		
		String success="Diagnostic Centre is deleted";
		return success;
		}
		return "Diagnostic Centre not present";
	}

	@Override
	public ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(DiagnosticCentre diagnosticCentre) {
		

		 Optional<DiagnosticCentre> findCentre = diagnosticCentrerepo.findById(diagnosticCentre.getcentreId());
			
			
	        try {
	            if (findCentre.isPresent()) {
	                diagnosticCentrerepo.save(diagnosticCentre);
	                return new ResponseEntity<DiagnosticCentre>(diagnosticCentre, HttpStatus.OK);
	            	} 
	            else {
	                throw new RecordNotFoundException("Diagnostic Centre is not present in the database");
	            }
	        }
	        catch (RecordNotFoundException e) {
	            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
		
	
		
	}

	@Override
	public ResponseEntity<DiagnosticCentre> findDiagnosticCentre1(String centreid) {
		
		Optional<DiagnosticCentre> findCentre=diagnosticCentrerepo.findById(centreid);
		try {
			if(findCentre.isPresent()) {
				DiagnosticCentre diagnosticCentre=findCentre.get();
				return new ResponseEntity<DiagnosticCentre>(diagnosticCentre,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Diagnostic Centre not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

package com.cg.iter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.DiagnosticCentre;

@Repository
public interface DiagnosticCentreRepositories extends JpaRepository<DiagnosticCentre,String> {
	
}

package com.cg.iter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.DiagnosticCentre;
@Repository
public interface CentreRepository extends JpaRepository<DiagnosticCentre,String>{
	
}
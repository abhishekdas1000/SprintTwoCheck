package com.cg.iter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{

	@Query("select m.userId from Appointment m where m.userId=?1")
	public List<String> checkUserIdEXists(String userId);
}


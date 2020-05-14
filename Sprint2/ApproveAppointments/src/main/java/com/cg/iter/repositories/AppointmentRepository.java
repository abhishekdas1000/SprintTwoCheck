package com.cg.iter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{

}
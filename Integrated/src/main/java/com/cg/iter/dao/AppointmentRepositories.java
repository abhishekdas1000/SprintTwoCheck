package com.cg.iter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Appointment;

@Repository
public interface AppointmentRepositories extends JpaRepository<Appointment, Integer>{

}

package com.cg.iter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
			
}

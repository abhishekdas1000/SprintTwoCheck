package com.cg.iter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Test;

@Repository
public interface TestRepositories extends JpaRepository<Test, Integer> {
	
}
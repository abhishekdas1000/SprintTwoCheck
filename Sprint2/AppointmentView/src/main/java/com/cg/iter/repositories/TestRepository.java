package com.cg.iter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Test;
@Repository
public interface TestRepository extends JpaRepository<Test,String>{

}
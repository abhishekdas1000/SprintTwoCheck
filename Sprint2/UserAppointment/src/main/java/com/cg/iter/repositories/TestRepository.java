package com.cg.iter.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iter.entity.Test;
@Repository
public interface TestRepository extends JpaRepository<Test,String>{

}

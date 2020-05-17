package com.cg.iter.service;

import java.util.List;

import com.cg.iter.entity.Admin;

public interface AdminService {
	
	public Admin findById(int id);
	public List<Admin>	findAll();
	public void save(Admin admin);
	
}

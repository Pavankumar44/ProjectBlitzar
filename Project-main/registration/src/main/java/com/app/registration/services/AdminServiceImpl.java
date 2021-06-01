package com.app.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Admin;
import com.app.registration.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Admin fetchAdminByUserNameAndPassword(String Name, String password) {

		return adminRepo.findByUserNameAndPassword(Name,password);
	}
	@Override
	public Admin fetchAdminByUserName(String name) {
		return adminRepo.findByUserName(name);
	}
	

}

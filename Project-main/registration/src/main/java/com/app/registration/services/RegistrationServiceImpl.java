package com.app.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.app.registration.model.Admin;
import com.app.registration.model.User;

import com.app.registration.repository.RegistrationRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationRepository repo;

	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public User fetchUserByEmailId(String email) {
		
		return repo.findByEmailId(email);
	}

	@Override
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		
		return repo.findByEmailIdAndPassword(email,password);
	}
	
	


	
	

}

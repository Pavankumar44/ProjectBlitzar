package com.app.registration.services;

import com.app.registration.model.User;

public interface RegistrationService {
	
	public User saveUser(User user);
	
	public User fetchUserByEmailId(String email);
	
	public User fetchUserByEmailIdAndPassword(String email, String password);
	

}

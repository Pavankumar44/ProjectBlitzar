package com.app.registration.controller;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.app.registration.model.Admin;
//import com.app.registration.model.Doctor;
//import com.app.registration.model.DoctorDTO;
//import com.app.registration.model.Hospital;
import com.app.registration.model.User;
//import com.app.registration.repository.DoctorRepository;
//import com.app.registration.repository.AdminRepository;
//import com.app.registration.repository.HospitalRepository;
//import com.app.registration.services.AdminService;
//import com.app.registration.services.DoctorService;
//import com.app.registration.services.AdminServiceImpl;
//import com.app.registration.services.HospitalService;
import com.app.registration.services.RegistrationService;
//import com.app.registration.services.RegistrationServiceImpl;


@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	
	
	//Registration
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			User userobj=service.fetchUserByEmailId(tempEmailId);
			if(userobj != null)
			{
				throw new Exception("User with "+tempEmailId+" is already exist"); 
			}
		}
		
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
		
	}
	
	//Login
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmailId!=null && tempPassword!=null)
		{
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
			
		}
		if(userObj == null)
		{
			throw new Exception("Invalid Credentials, Please check your User Id and Password");
		}
		return userObj;		
	}

}

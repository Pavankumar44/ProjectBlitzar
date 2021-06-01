package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Admin;
import com.app.registration.services.AdminService;


@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/adminlogin")
	@CrossOrigin(origins="http://localhost:4200")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception
	{
		String tempUserName = admin.getUserName();
		String tempPassword = admin.getPassword();
		Admin adminObj = null;
	
		if(tempUserName!=null && tempPassword!=null)
		{
			
			adminObj = adminService.fetchAdminByUserNameAndPassword(tempUserName, tempPassword);		
			
		}
		if(adminObj == null)
		{
			throw new Exception("Invalid Credentials, Please check your User Name and Password");
		}
	   return adminObj;	
		
	}

}

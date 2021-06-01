package com.app.registration.services;

import com.app.registration.model.Admin;

public interface AdminService {
	
	public Admin fetchAdminByUserNameAndPassword(String Name, String password);
	public Admin fetchAdminByUserName(String name);

}

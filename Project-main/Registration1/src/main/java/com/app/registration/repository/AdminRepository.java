package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	
    public Admin findByUserNameAndPassword(String userName,String password);
	
	public Admin findByUserName(String userName);

}

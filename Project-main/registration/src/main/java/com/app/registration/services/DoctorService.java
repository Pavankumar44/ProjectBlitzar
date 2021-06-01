package com.app.registration.services;

import java.util.List;
//import java.util.List;
//import java.util.Optional;

import com.app.registration.model.Doctor;
//import com.app.registration.model.Hospital;


public interface DoctorService {
	
	//boolean saveDoctor(Doctor doctor);
	Doctor findByDoctorName(String DoctorName);
	boolean deleteDoctor(Long id);
	//public Doctor updateDoctor(Doctor doctor);
	Doctor getById(Long id);
	Doctor add(Doctor doctor);
	Doctor update(Doctor doctor);
	List<Doctor> getAll();
	

}

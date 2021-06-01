package com.app.registration.services;

import java.util.List;
//import java.util.List;

import com.app.registration.model.Hospital;

public interface HospitalService {
	Hospital add(Hospital hospital);
	Hospital findByHospitalName(String hospitalName);
	boolean deleteHospital(Long id);
	public Hospital update(Hospital hospital);
	Hospital getById(Long id);
	List<Hospital> getAll();
//	Hospital getById(Long id);
//	List<Hospital> getAllHospitals();
	
	

	
	
	
	


}

package com.app.registration.services;

import java.util.List;
//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Hospital;

import com.app.registration.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalRepository repository;
	

	@Override
	public Hospital add(Hospital hospital) {
		repository.save(hospital);
		return hospital;
	}

	@Override
	public Hospital findByHospitalName(String hospitalName) {
		
		Hospital hospital = repository.findByHospitalName(hospitalName);
		
		return hospital;
	}

	

	@Override
	public Hospital update(Hospital hospital) {
		return repository.save(hospital);
	}

	@Override
	public Hospital getById(Long id) {
		Hospital hospital = repository.findById(id).get();
		return hospital;
	}

	@Override
	public boolean deleteHospital(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<Hospital> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

//	@Override
//	public Hospital saveHospital(Hospital hospital) {
//		Hospital save = repository.save(hospital);
//		return save;
//	}
//
//	@Override
//	public Hospital findByHospitalName(String hospitalName) {
//		
//		Hospital hospital = repository.findByHospitalName(hospitalName);
//		
//		return hospital;
//	}
//
//	
//
//	@Override
//	public Hospital updateHospital(Hospital hospital) {
//		Hospital hos = repository.updateHospital();
//		hos.setId(hospital.getId());
//		hos.setHospitalName(hospital.getHospitalName());
//		hos.setStreetAddress(hospital.getStreetAddress());
//		hos.setStreetAddress2(hospital.getStreetAddress2());
//		hos.setCity(hospital.getCity());
//		hos.setPincode(hospital.getPincode());
//		hos.setContactNo(hospital.getContactNo());
//		Hospital save = repository.save(hos);
//		return save;
//	}
//
//	@Override
//	public Optional<Hospital> findById(Long id) {
//		Optional<Hospital> hospital = repository.findById(id);
//		return hospital;
//	}
//
//	@Override
//	public boolean deleteHospital(Long id) {
//		// TODO Auto-generated method stub
//		repository.deleteById(id);
//		return false;
//	}
	
//	@Override
//	public Hospital getById(Long id) {
//		Hospital hospital = repository.getById(id);
//		return hospital;
//	}
//
//	@Override
//	public List<Hospital> getAllHospitals() {
//		
//		List<Hospital> hosp = repository.findAll();
//		return hosp;
//	}

	
	


}

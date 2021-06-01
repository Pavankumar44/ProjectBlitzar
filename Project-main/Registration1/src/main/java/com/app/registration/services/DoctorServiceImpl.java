package com.app.registration.services;

import java.util.List;
//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Doctor;
//import com.app.registration.model.Hospital;
import com.app.registration.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	public DoctorRepository repository;
	@Autowired
	public HospitalService hospitalService;
	
	@Override
	public Doctor add(Doctor Doctor) {
		return repository.save(Doctor);
	}

	@Override
	public Doctor findByDoctorName(String doctorName) {
		
		Doctor doctor = repository.findByDoctorName(doctorName);
		
		return doctor;
	}

	

	@Override
	public Doctor update(Doctor doctor) {
		return repository.save(doctor);
	}

	@Override
	public Doctor getById(Long id) {
		Doctor doctor = repository.findById(id).get();
		return doctor;
	}

	@Override
	public boolean deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<Doctor> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

//	@Override
//	public Doctor saveDoctor(Doctor doctor) {
//		Doctor save = repository.save(doctor);
//		return save;
//	}
//
//	@Override
//	public Doctor findByDoctorName(String doctorName) {
//    Doctor doctor = repository.findByDoctorName(doctorName);
//		
//		return doctor;
//	}
//
//	@Override
//	public boolean deleteDoctor(Long id) {
//		repository.deleteById(id);
//		return false;
//	}
//
//	@Override
//	public Doctor updateDoctor(Doctor doctor) {
//		Doctor doc = this.updateDoctor(doctor);
//		doc.setDoctorName(doctor.getDoctorName());
//		doc.setDepartment(doctor.getDepartment());
//		doc.setGender(doctor.getGender());
//		doc.setPhoneNo(doctor.getPhoneNo());
//		Doctor save = repository.save(doc); 
//		
//		return save;
//	}
//
//	@Override
//	public Doctor getById(Long id) {
//		Doctor doctor = repository.getById(id);
//		return doctor;
//	}
//
//	@Override
//	public List<Doctor> getDoctorOfHospital(Long id) {
//		
//		Hospital hospital = hospitalService.getById(id);
//		
//		return hospital.getDoctor();
//	}
     
	
	
}

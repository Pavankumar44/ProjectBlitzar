package com.app.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findById(Long id);
	
	Doctor findByDoctorName(String doctorName);
	
}

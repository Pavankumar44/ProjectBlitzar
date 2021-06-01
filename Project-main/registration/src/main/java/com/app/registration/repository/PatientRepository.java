package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

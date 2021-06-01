package com.app.registration.model;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String LastName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String phoneNo;
//	@ManyToOne(targetEntity = Doctor.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "doctorId", referencedColumnName = "id")
//	private Doctor doctor;
//	@ManyToOne(targetEntity = Hospital.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "hospitalId", referencedColumnName = "id")
//	private Hospital hospital;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

//	public Doctor getDoctor() {
//		return doctor;
//	}
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
//	public Hospital getHospital() {
//		return hospital;
//	}
//	public void setHospital(Hospital hospital) {
//		this.hospital = hospital;
//	}
	
	}

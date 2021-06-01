package com.app.registration.model;





import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;




@Entity
public class Doctor implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String doctorName;
	private String department;
	private String gender;
	private Long phoneNo;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hId", referencedColumnName = "id")
	private Hospital hospital;
	
	
	
	public Doctor() {
		
	}
	
	
	public Doctor(Long id, String doctorName, String department, String gender, Long phoneNo) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.department = department;
		this.gender = gender;
		this.phoneNo = phoneNo;
		
	}
	


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}




	
	

}

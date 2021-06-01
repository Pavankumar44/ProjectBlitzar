package com.app.registration.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;




@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler", "doctor"})
public class Hospital implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hospitalName;
	private String streetAddress;
	private String streetAddress2;
	private String city;
	private Long pincode;
	private Long contactNo;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospital")
	private List<Doctor> doctor;
	
	
	
	public Hospital() {
		
	}
	public Hospital(Long id, String hospitalName, String streetAddress, String streetAddress2, String city, Long pincode,
			Long contactNo, List<Doctor> doctor) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.streetAddress = streetAddress;
		this.streetAddress2 = streetAddress2;
		this.pincode = pincode;
		this.city = city;
		this.contactNo = contactNo;
		this.doctor = doctor;
		
	}
	
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
	
	
	


}

package com.app.registration.controller;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Doctor;
import com.app.registration.model.Hospital;
//import com.app.registration.model.Hospital;
//import com.app.registration.model.DoctorDTO;
//import com.app.registration.model.Hospital;
import com.app.registration.repository.DoctorRepository;
import com.app.registration.repository.HospitalRepository;
import com.app.registration.services.DoctorService;
import com.app.registration.services.HospitalService;
//import com.app.registration.services.HospitalService;


@RestController
public class DoctorController {
	
	@Autowired
	public DoctorService doctorService;
	@Autowired
	public DoctorRepository repository;
	@Autowired
	public HospitalService hospitalService;
	
	
	
	 @GetMapping("/doctors")
	 @CrossOrigin(origins="http://localhost:4200")
	 public List<Doctor> getAll() {
  	  return doctorService.getAll();
    }
    
	// http://localhost:8800/api/customer
	@PostMapping("/doctors/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> add(@RequestBody Doctor doctor,@PathVariable Long id) {
		if (doctor != null) {
			Hospital hospital = hospitalService.getById(id);
			doctor.setHospital(hospital);
			Doctor add = doctorService.add(doctor);
			
			return new ResponseEntity<>("Doctor Saved Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No doctor Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/doctors/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		if (id != null) {
			Doctor doc = doctorService.getById(id);

			return new ResponseEntity<>(doc, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Not doctor found with doctorName " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/doctors/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> deleteDoctorById(@PathVariable Long id) {
		if (id != null) {
			doctorService.deleteDoctor(id);

			return new ResponseEntity<>("Doctor deleted Successfully", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Not Id found " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/doctors/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> update(@PathVariable Long id , @RequestBody Doctor doctor) {
		Doctor doc = doctorService.getById(id);
		if (doc != null) {
			doctorService.update(doctor);

			return new ResponseEntity<>(doc, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//Doctor
//	 	@GetMapping("/doctors/{id}")
//		  @CrossOrigin(origins="http://localhost:4200")
//		  public List<DoctorDTO> getDoctorList(@PathVariable("id")Long id) {
//	 		
//	 		List<Doctor> doctors = doctorService.getDoctorOfHospital(id);
//	 		List<DoctorDTO> doctorList = new ArrayList<>();
//	 		for(Doctor doctor: doctors) {
//	 			DoctorDTO doc = this.getDoctorDTO(doctor);
//	 			doctorList.add(doc);
//	 		}
//	 		
//	 	  return doctorList;
//	   }
//	   
//		// http://localhost:8800/api/customer
//		@PostMapping("/doctors/{id}")
//		@CrossOrigin(origins="http://localhost:4200")
//		public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor, @PathVariable Long id) {
//			if (doctor != null) {
//				Hospital hospital = hospitalService.getById(id);
//				 doctor.setHospital(hospital);
//				
//				 Doctor saveDoctor = doctorService.saveDoctor(doctor);
//				 DoctorDTO doc = this.getDoctorDTO(saveDoctor);
//				return new ResponseEntity<>(doc, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>("No Doctor Found", HttpStatus.NOT_FOUND);
//			}
//		}
//
//		private DoctorDTO getDoctorDTO(Doctor doctor) {
//			DoctorDTO doc = new DoctorDTO();
//			doc.setId(doctor.getId());
//			doc.setDoctorName(doctor.getDoctorName());
//			doc.setDepartment(doctor.getDepartment());
//			doc.setGender(doctor.getGender());
//		    doc.setPhoneNo(doctor.getPhoneNo());
//			return doc;
//		}
//
//		@GetMapping("/doctors/{id}")
//		@CrossOrigin(origins="http://localhost:4200")
//		public ResponseEntity<?> getDoctor(@PathVariable Long id) {
//			if (id != null) {
//				Doctor doc = doctorService.getById(id);
//				DoctorDTO doct = this.getDoctorDTO(doc);
//				return new ResponseEntity<>(doct, HttpStatus.OK);
//
//			} else {
//				return new ResponseEntity<>("Not hospital found with HospitalName " + id, HttpStatus.NOT_FOUND);
//			}
//		}
//		
//		@DeleteMapping("/doctors/{id}")
//		@CrossOrigin(origins="http://localhost:4200")
//		public ResponseEntity<?> deleteDoctorById(@PathVariable Long id) {
//			if (id != null) {
//				doctorService.deleteDoctor(id);
//
//				return new ResponseEntity<>("Doctor deleted Successfully", HttpStatus.OK);
//
//			} else {
//				return new ResponseEntity<>("Not Id found " + id, HttpStatus.NOT_FOUND);
//			}
//		}
//		
//		@PutMapping("/doctors/{id}")
//		@CrossOrigin(origins="http://localhost:4200")
//		public ResponseEntity<?> updateDoctor(@PathVariable Long id , @RequestBody Doctor doctor) {
//			Doctor doc = doctorService.updateDoctor(doctor);
//			if (doc != null) {
//				Doctor updateDoctor = doctorService.updateDoctor(doc);
//                DoctorDTO doct = this.getDoctorDTO(updateDoctor);
//                
//				return new ResponseEntity<>(doct, HttpStatus.OK);
//
//			} else {
//			
//				return new ResponseEntity<>(doc, HttpStatus.NOT_FOUND);
//			}
//		}

}

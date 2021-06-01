package com.app.registration.controller;


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



import com.app.registration.model.Hospital;
import com.app.registration.repository.HospitalRepository;
import com.app.registration.services.HospitalService;


@RestController
public class HospitalController {
	
	
	@Autowired
	public HospitalService hospitalService;
	@Autowired
	public HospitalRepository hospitalRepository;
	
	
	 @GetMapping("/hospitals")
	 @CrossOrigin(origins="http://localhost:4200")
	  public List<Hospital> getAll() {
   	  return hospitalService.getAll();
     }
     
 	// http://localhost:8800/api/customer
 	@PostMapping("/hospitals")
 	@CrossOrigin(origins="http://localhost:4200")
 	public ResponseEntity<?> add(@RequestBody Hospital hospital) {
 		if (hospital != null) {
 			hospitalService.add(hospital);
 			return new ResponseEntity<>(hospital, HttpStatus.OK);
 		} else {
 			return new ResponseEntity<>("No Hospital Found", HttpStatus.NOT_FOUND);
 		}
 	}

 	@GetMapping("/hospitals/{id}")
 	@CrossOrigin(origins="http://localhost:4200")
 	public ResponseEntity<?> getHospitalById(@PathVariable Long id) {
 		if (id != null) {
 			Hospital hosp = hospitalService.getById(id);

 			return new ResponseEntity<>(hosp, HttpStatus.OK);

 		} else {
 			return new ResponseEntity<>("Not Hospital found with HospitalName " + id, HttpStatus.NOT_FOUND);
 		}
 	}
 	
 	@DeleteMapping("/hospitals/{id}")
 	@CrossOrigin(origins="http://localhost:4200")
 	public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
 		if (id != null) {
 			hospitalService.deleteHospital(id);

 			return new ResponseEntity<>("Hospital deleted Successfully", HttpStatus.OK);

 		} else {
 			return new ResponseEntity<>("Not Id found " + id, HttpStatus.NOT_FOUND);
 		}
 	}
 	
 	@PutMapping("/hospitals/{id}")
 	@CrossOrigin(origins="http://localhost:4200")
 	public ResponseEntity<?> updateHospital(@PathVariable Long id , @RequestBody Hospital hospital) {
 		Hospital hosp = hospitalService.getById(id);
 		if (hosp != null) {
 			hospitalService.update(hospital);

 			return new ResponseEntity<>(hosp, HttpStatus.OK);

 		} else {
 			return new ResponseEntity<>(hosp, HttpStatus.NOT_FOUND);
 		}
 	}
	
//	@GetMapping("/hospitals")
//	  @CrossOrigin(origins="http://localhost:4200")
//	  public List<HospitalDTO> getHospitals() {
//		
//		List<Hospital> allHospitals = hospitalService.getAllHospitals();
//		List<HospitalDTO> hospital = new ArrayList<>();
//		for(Hospital hosp: allHospitals) {
//			HospitalDTO hos = new HospitalDTO();
//			hos.setId(hosp.getId());
//			hos.setHospitalName(hosp.getHospitalName());
//			hos.setStreetAddress(hosp.getHospitalName());
//			hos.setStreetAddress2(hosp.getStreetAddress2());
//			hos.setCity(hosp.getCity());
//			hos.setPincode(hosp.getPincode());
//			hos.setContactNo(hosp.getContactNo());
//			
//			hospital.add(hos);
//			
//		}
//		  
// 	  return hospital;
//   }
//   
//	
//	@PostMapping("/hospitals")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<?> saveHospital(@RequestBody Hospital hospital) {
//		if (hospital != null) {
//			
//			Hospital hp = hospitalService.saveHospital(hospital);
//			HospitalDTO hosp = new HospitalDTO();
//			hosp.setId(hp.getId());
//			hosp.setHospitalName(hp.getHospitalName());
//			hosp.setStreetAddress(hp.getStreetAddress());
//			hosp.setStreetAddress2(hp.getStreetAddress2());
//			hosp.setCity(hp.getCity());
//			hosp.setPincode(hp.getPincode());
//			hosp.setContactNo(hp.getContactNo());
//			return new ResponseEntity<>(hosp, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("No Hospital Found", HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@GetMapping("/hospitals/{id}")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<?> getHospital(@PathVariable Long id) {
//		if (id != null) {
//			Hospital hos = hospitalService.getById(id);
//			HospitalDTO host = this.getHospital(id);
//			return new ResponseEntity<>(host, HttpStatus.OK);
//
//		} else {
//			return new ResponseEntity<>("Not hospital found with HospitalName " + id, HttpStatus.NOT_FOUND);
//		}
//	}
//
//
//	@DeleteMapping("/hospitals/{id}")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
//		if (id != null) {
//			hospitalService.deleteHospital(id);
//
//			return new ResponseEntity<>("Customer deleted Successfully", HttpStatus.OK);
//
//		} else {
//			return new ResponseEntity<>("Not Id found " + id, HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@PutMapping("/hospitals/{id}")
//	@CrossOrigin(origins="http://localhost:4200")
//	public ResponseEntity<?> updateHospital(@PathVariable Long id , @RequestBody Hospital hospital) {
//		Hospital hos = hospitalService.updateHospital(hospital);
//		if (hos != null) {
//			Hospital updateHospital = hospitalService.updateHospital(hos);
//            HospitalDTO hosp = this.getHospital(id);
//            
//			return new ResponseEntity<>(hosp, HttpStatus.OK);
//
//		} else {
//		
//			return new ResponseEntity<>(hosp, HttpStatus.NOT_FOUND);
//		}
//	}

}

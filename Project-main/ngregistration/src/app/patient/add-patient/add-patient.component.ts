import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/doctor';
import { DoctorService } from 'src/app/doctor.service';
import { Hospital } from 'src/app/hospital';
import { HospitalService } from 'src/app/hospital.service';
import { PatientService } from 'src/app/patient.service';


@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  hospitals: Hospital[];

  doctors: Doctor[];

  signupForm: FormGroup;
  constructor(private patientService: PatientService,private hospitalService: HospitalService, private doctorService: DoctorService,private router: Router) { }

  ngOnInit(): void {

    this.signupForm = new FormGroup({
      id: new FormControl(null),
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      dateOfBirth: new FormControl(null, Validators.required),
      address: new FormControl(null, Validators.required),
      address2: new FormControl(null, Validators.required),
      city: new FormControl(null, Validators.required),
      pincode: new FormControl(null, Validators.required),
      phoneNo: new FormControl(null, Validators.required),
      hospital: new FormControl(null, Validators.required),
      doctor: new FormControl(null, Validators.required),
      timeSlots:new FormControl(null, Validators.required)
      });

      this.hospitalService.getAllHospitals().subscribe(hospital => {
        this.hospitals = hospital; 
  });
      this.doctorService.getAllDoctors().subscribe(doctor => {
      this.doctors = doctor; 
  });
  }

  onSubmit(): void{
    this.patientService.createPatient(this.signupForm.value).subscribe(data =>{
      console.log("Form Submitted successfully");
      this.router.navigate(['/add-patient']);
    });
    console.log(this.signupForm);
  }
}

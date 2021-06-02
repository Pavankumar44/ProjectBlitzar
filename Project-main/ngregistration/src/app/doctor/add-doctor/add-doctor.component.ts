import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from 'src/app/doctor.service';
import { Hospital } from 'src/app/hospital';
import { HospitalService } from 'src/app/hospital.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  hospitals: Hospital[];

  signupForm: FormGroup;
  constructor(private doctorService: DoctorService, private hospitalService: HospitalService ,private router: Router) { }

  ngOnInit(): void {

    this.signupForm = new FormGroup({
      id: new FormControl(null),
      doctorName: new FormControl(null, Validators.required),
      department: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      phoneNo: new FormControl(null, Validators.required),
      h1id: new FormControl(null, Validators.required)
    });

   this.hospitalService.getAllHospitals().subscribe(hospital => {
         this.hospitals = hospital;
   });
    }

  onSubmit(): void{
    //this.countfromChild.emit(this.countfromParent + 5);
    this.doctorService.createDoctor(this.signupForm.value).subscribe(data =>{
      console.log("Doctor Registered Successfullt" + data);
      this.router.navigate(['/doctors']);
    });
    // console.log(this.signupForm);
}
}

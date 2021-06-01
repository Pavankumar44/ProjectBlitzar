import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit {

  updateForm: FormGroup;

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    this.updateForm = new FormGroup({
      id: new FormControl(null),
      doctorName: new FormControl(null, Validators.required),
      department: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      phoneNo: new FormControl(null, Validators.required)
    })
    const id =localStorage.getItem('id');
    if(+id! > 0){
      this.doctorService.getDoctorById(+id!).subscribe(data =>{
        this.updateForm.patchValue(data);
      });
    }

  }
  onSubmit(): void {
    this.doctorService.updateDoctor(this.updateForm.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/doctors']);
    });
  }

}

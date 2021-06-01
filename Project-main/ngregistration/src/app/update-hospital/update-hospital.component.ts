import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HospitalService } from '../hospital.service';

@Component({
  selector: 'app-update-hospital',
  templateUrl: './update-hospital.component.html',
  styleUrls: ['./update-hospital.component.css']
})
export class UpdateHospitalComponent implements OnInit {

  updateForm: FormGroup;

  constructor(private hospitalService: HospitalService, private router: Router) { }

  ngOnInit(): void {
    this.updateForm = new FormGroup({
      id: new FormControl(null),
      hospitalName: new FormControl(null, Validators.required),
      streetAddress: new FormControl(null, Validators.required),
      streetAddress2: new FormControl(null, Validators.required),
      city: new FormControl(null, Validators.required),
      pincode: new FormControl(null, Validators.required),
      contactNo: new FormControl(null, Validators.required) 
    })
    const id =localStorage.getItem('id');
    if(+id! > 0){
      this.hospitalService.getHospitalById(+id!).subscribe(data =>{
        this.updateForm.patchValue(data);
      });
    }

  }
  onSubmit(): void {
    this.hospitalService.updateHospital(this.updateForm.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/hospitals']);
    });
  }

}

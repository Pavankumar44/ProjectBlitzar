import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  doctors: Doctor[];

  constructor(private doctorService:DoctorService, private router: Router) {}
  //students: Student[] = STUDENTS;
      ngOnInit(): void {
         this.doctorService.getAllDoctors().subscribe(data => {
              this.doctors=data;
         });
      }

      updateDoctor(doctor: Doctor): void{
          localStorage.removeItem('id');
          localStorage.setItem('id', doctor.id.toString());
          this.router.navigate(['update-doctor']);
      }

      deleteDoctor(doctor: Doctor):void{
          this.doctorService.deleteDoctorById(doctor.id).subscribe();
          this.doctors = this.doctors.filter(h => h !== doctor);
      }


}

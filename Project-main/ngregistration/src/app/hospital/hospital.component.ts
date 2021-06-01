import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hospital } from '../hospital';
import { HospitalService } from '../hospital.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospitals: Hospital[];

  constructor(private hospitalService:HospitalService, private router: Router) {}
  //students: Student[] = STUDENTS;
      ngOnInit(): void {
         this.hospitalService.getAllHospitals().subscribe(data => {
              this.hospitals=data;
         });
      }

      updateHospital(hospital: Hospital): void{
          localStorage.removeItem('id');
          localStorage.setItem('id', hospital.id.toString());
          this.router.navigate(['update-hospital']);
      }

      deleteHospital(hospital: Hospital):void{
          this.hospitalService.deleteHospitalById(hospital.id).subscribe();
          this.hospitals = this.hospitals.filter(h => h !== hospital);
      }

}

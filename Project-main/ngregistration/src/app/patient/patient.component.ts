import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  patients: Patient[];

  constructor(private patientService:PatientService, private router: Router) {}

      ngOnInit(): void {
         this.patientService.getAllPatients().subscribe(data => {
              this.patients=data;
         });
      }

}

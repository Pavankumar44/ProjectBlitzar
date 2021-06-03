import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  baseUrl = 'http://localhost:9000/patients';


  constructor(private httpClient: HttpClient) { }

  getAllPatients(): Observable<Patient[]> {
    
    return this.httpClient.get<Patient[]>(this.baseUrl);
  }

  createPatient(patient:Patient): Observable<Patient>{
    return this.httpClient.post<Patient>(this.baseUrl, patient);
  }
}

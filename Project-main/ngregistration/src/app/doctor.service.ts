import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';


@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  baseUrl = 'http://localhost:9000/doctors';


  constructor(private httpClient: HttpClient) { }

  getAllDoctors(): Observable<Doctor[]> {
    
    return this.httpClient.get<Doctor[]>(this.baseUrl);
  }

  createDoctor(doctor:Doctor): Observable<Doctor>{
    return this.httpClient.post<Doctor>(this.baseUrl + '/' + doctor.h1id, doctor);
  }

  getDoctorById(id: number): Observable<Doctor> {
    return this.httpClient.get<Doctor>(this.baseUrl+ '/' + id);
  }

  deleteDoctorById(id: number): Observable<Doctor>{
    return this.httpClient.delete<Doctor>(this.baseUrl + '/' + id);

  }
  updateDoctor(doctor: Doctor): Observable<Doctor> {
    return this.httpClient.put<Doctor>(this.baseUrl + '/' + doctor.id , doctor);
  }
}

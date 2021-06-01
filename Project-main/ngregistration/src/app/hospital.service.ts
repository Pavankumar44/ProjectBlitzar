import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hospital } from './hospital';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {


  baseUrl = 'http://localhost:9000/hospitals';


  constructor(private httpClient: HttpClient) { }

  getAllHospitals(): Observable<Hospital[]> {
    return this.httpClient.get<Hospital[]>(this.baseUrl);
  }

  createHospital(hospital:Hospital): Observable<Hospital>{
    return this.httpClient.post<Hospital>(this.baseUrl, hospital);
  }

  getHospitalById(id: number): Observable<Hospital> {
    return this.httpClient.get<Hospital>(this.baseUrl+ '/' + id);
  }

  deleteHospitalById(id: number): Observable<Hospital>{
    return this.httpClient.delete<Hospital>(this.baseUrl + '/' + id);

  }
  updateHospital(hospital: Hospital): Observable<Hospital> {
    return this.httpClient.put<Hospital>(this.baseUrl + '/' + hospital.id , hospital);
  }
}

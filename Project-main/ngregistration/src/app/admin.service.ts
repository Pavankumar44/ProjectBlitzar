import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private _http : HttpClient) { }

  public loginAdminFromRemote(admin :Admin):Observable<any>{
    return  this._http.post<any>("http://localhost:9000/adminlogin",admin)

  }
  
}

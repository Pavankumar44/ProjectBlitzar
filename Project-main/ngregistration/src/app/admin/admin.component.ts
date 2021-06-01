import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { RegistrationService } from '../registration.service';
import {NgForm} from '@angular/forms';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  admin = new Admin();
  msg='';

  constructor(private _service : AdminService, private _router : Router) { }

  ngOnInit(): void {
  }
  loginAdmin(){
    this._service.loginAdminFromRemote(this.admin).subscribe(
      data => {
        console.log("response received");
        this._router.navigate(['/hospitals'])
      },
      error => {
        console.log("Exception occured");
        this.msg="Invalid Credentials, Please check your Email Id and Password";
      }
    )

  }
  gotouserlogin(){
    this._router.navigate(['/login'])
    //this willl navigate to /registration goto app-routing where this registration is then linked with registrationcomponent using path
  }

}

import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   user = new User();
   msg='';

  constructor(private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe(
      data => {
        console.log("response received");
        this._router.navigate(['/add-patient'])
      } ,
      error => {
        console.log("Exception occured");
        this.msg="Invalid Credentials, Please check your Email Id and Password";
      }
    )

  }
  gotoregistration(){
    this._router.navigate(['/registration'])
    //this willl navigate to /registration goto app-routing where this registration is then linked with registrationcomponent using path
  }
  gotoadminlogin(){
    this._router.navigate(['/adminlogin'])
    //this willl navigate to /registration goto app-routing where this registration is then linked with registrationcomponent using path
  }

}

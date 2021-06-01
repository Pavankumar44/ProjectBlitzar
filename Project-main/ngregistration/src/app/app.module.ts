import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { OpformComponent } from './opform/opform.component';
import { AdminComponent } from './admin/admin.component';
import { HospitalComponent } from './hospital/hospital.component';
import { AddHospitalComponent } from './hospital/add-hospital/add-hospital.component';
import { UpdateHospitalComponent } from './update-hospital/update-hospital.component';
import { DoctorComponent } from './doctor/doctor.component';
import { AddDoctorComponent } from './doctor/add-doctor/add-doctor.component';
import { UpdateDoctorComponent } from './update-doctor/update-doctor.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    OpformComponent,
    AdminComponent,
    HospitalComponent,
    AddHospitalComponent,
    UpdateHospitalComponent,
    DoctorComponent,
    AddDoctorComponent,
    UpdateDoctorComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AddDoctorComponent } from './doctor/add-doctor/add-doctor.component';
import { DoctorComponent } from './doctor/doctor.component';
import { AddHospitalComponent } from './hospital/add-hospital/add-hospital.component';
import { HospitalComponent } from './hospital/hospital.component';
import { LoginComponent } from './login/login.component';
import { OpformComponent } from './opform/opform.component';
import { RegistrationComponent } from './registration/registration.component';
import { UpdateDoctorComponent } from './update-doctor/update-doctor.component';
import { UpdateHospitalComponent } from './update-hospital/update-hospital.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'opform',component:OpformComponent},
  {path:'registration',component:RegistrationComponent},
  {path: 'login',component:LoginComponent},
  {path: 'adminlogin',component:AdminComponent},
  {path: 'hospitals', component:HospitalComponent},
  {path:'add-hospital', component: AddHospitalComponent},
  {path:'hospital/:id', component: HospitalComponent},
  {path:'update-hospital',component: UpdateHospitalComponent},
  {path:'doctors',component:DoctorComponent},
  {path:'add-doctor',component: AddDoctorComponent},
  {path:'doctor/:id',component: DoctorComponent},
  {path:'update-doctor',component: UpdateDoctorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

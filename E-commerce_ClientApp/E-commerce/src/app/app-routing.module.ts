import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ECommerceComponent } from './e-commerce/e-commerce.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:"signupview",component:SignupComponent},
  {path:"loginview",component:LoginComponent},
  {path:"e-commerceview",component:ECommerceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

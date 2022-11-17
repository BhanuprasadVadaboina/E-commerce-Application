import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CommerceService } from './commerce.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpclient:HttpClient,private commerce_service:CommerceService) { }

  baseURL:any="http://localhost:5522/Vehicle-app/v1";

  baseURL2:any="http://localhost:3000/Userapp/v1";

  signup(user:any){
   return this.httpclient.post(this.baseURL+"/addUser",user);
  }

  login(user:any){
    console.log(this.baseURL+"/user-check");
    return this.httpclient.post(this.baseURL2+"/user-check",user);
   
  }

  commerce_srvce(userobject:any){
   this.commerce_service.getUserobject(userobject);
   console.log("klkl");
  }

}

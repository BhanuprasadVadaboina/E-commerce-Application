import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommerceService {

  constructor(public httpclient:HttpClient) { }

  base_url="http://localhost:5522/Vehicle-app/v1";

  httpheaders=new HttpHeaders({
    'Authorization': 'Bearer '+localStorage.getItem('jwt')
  });

  requestheader={ headers : this.httpheaders};

  getAllvehicles(){
    console.log(this.base_url+"/get-all-vehicles");
    return this.httpclient.get(this.base_url+"/get-all-vehicles");
    
  }

  addvehicle(vehicle:any){

    return this.httpclient.post(this.base_url+"/add-vehicle",vehicle,this.requestheader);
  }

  removevehicle(vehicleId:any){
    // console.log(this.base_url+"/remove-Vehicle/"+vehicleId);
    return this.httpclient.delete(this.base_url+"/remove-Vehicle/"+vehicleId,this.requestheader);

  }

  updatevehicle(vehicle:any){
    return this.httpclient.put(this.base_url+"/update-vehicle",vehicle,this.requestheader);
  }

  addtocart(email:any,vehicle:any){
    // console.log(this.base_url+"/add-to-cart/"+email,vehicle);
    return this.httpclient.put(this.base_url+"/add-to-cart/"+email,vehicle);
  }

  
  addUser(user:any){
    return this.httpclient.post(this.base_url+"/addUser",user,this.requestheader);
  }

  getUser(){
    return this.httpclient.get(this.base_url+"/get-User/"+this.user_object.email_id,this.requestheader);
  }

  userviewcart(emailId:any){
      return this.httpclient.get(this.base_url+"/user-view-cart/"+emailId);
  }


  user_object:any=null;

  getUserobject(userobject:any){
      this.user_object=userobject;
      console.log(userobject);
  }

}

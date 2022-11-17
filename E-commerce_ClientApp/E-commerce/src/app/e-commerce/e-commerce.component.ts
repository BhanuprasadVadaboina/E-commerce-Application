import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CommerceService } from '../commerce.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-e-commerce',
  templateUrl: './e-commerce.component.html',
  styleUrls: ['./e-commerce.component.css']
})
export class ECommerceComponent implements OnInit {

  constructor(private commerceservice:CommerceService,private userservice:UserService) {
    this.getRole();
    this.getAllVehicles();
       }

  ngOnInit(): void {
  }

  vehicles:any;


  getAllVehicles(){
    this.commerceservice.getAllvehicles().subscribe(
      r=>{
        this.vehicles=r;
      }
    )
  }

  vehicleForm=new FormGroup({
    "vehicleId":new FormControl(''),
    "vehicle_name":new FormControl(''),
    "color":new FormControl(''),
    "fuelType":new FormControl(''),
    "noOfSeats": new FormControl(''),
    "safety": new FormControl('')
  })

 
 

  addVehicle(){
    this.commerceservice.addvehicle(this.vehicleForm.value).subscribe(
      r2=>{
        alert("vehicle is added into database");
      }
    )
  }

  deleteVehicle(vehicleId:any){
    this.commerceservice.removevehicle(vehicleId).subscribe(
      r3=>{
        alert("selected vehicle is removed");
      }
    )
  }

  updateVehicle(){
    this.commerceservice.updatevehicle(this.updateForm.value).subscribe(
      r4=>{
        alert("updated succesfully");
      }
    )
  }

  addtocart(vehicle:any){
    if(this.role==null){
      alert("please Login to continue");
    }
    else{
    this.commerceservice.addtocart(this.commerceservice.user_object.email_id,vehicle,).subscribe(
      r=>{
        console.log(r);
      }
    )
    console.log("adding to cart");
  }
  }

enable:Boolean=false;

  update(b:any){
    this.enable=true;
    console.log(b);
    this.updateForm.setValue(b);
  }

  updateForm=new FormGroup({
    "vehicleId":new FormControl(''),
    "vehicle_name":new FormControl(''),
    "color":new FormControl(''),
    "fuelType":new FormControl(''),
    "noOfSeats": new FormControl(''),
    "safety": new FormControl('')
  })

  // getuser(){
  //   this.commerceservice.getUser().subscribe(
  //     r4=>{
  //       console.log("hi user");
  //     }
  //   )
  // }

  cartItems:any; 

  viewcart(){
    
    this.commerceservice.userviewcart(this.emailId).subscribe(
      r2=>{
        this.cartItems=r2;
      }
    )
  }

  refresh(){
    this.viewcart();
  }

  refresh1(){
    this.getAllVehicles();
  }

  

  role:any;
  name:any;
  emailId:any;

  getRole(){
    console.log(this.commerceservice.user_object.role);
    this.role=this.commerceservice.user_object.role;
    this.name=this.commerceservice.user_object.user_name;
    this.emailId=this.commerceservice.user_object.email_id;
    // console.log(this.role);
    // console.log(this.commerceservice.userrole);
    // this.getuser();
  }

}

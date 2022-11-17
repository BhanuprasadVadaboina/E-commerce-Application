import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';
import jwt_decode from 'jwt-decode';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userservice:UserService,private root:AppComponent) {this.role(); }

  ngOnInit(): void {
  }

  loginForm=new FormGroup({
    user_id:new FormControl(''),
    password:new FormControl('')
  })
  
  responsetoken:any;

  decoded:any;

  userobject:any;


  login(){
    this.userservice.login(this.loginForm.value).subscribe(
      response=>{
      console.log(response);
      this.root.enable=true;
        this.responsetoken=response;
      console.log(this.responsetoken.token);
        const token=this.responsetoken.token;
        this.decoded= jwt_decode(token);
      console.log(this.decoded.UserObject);
        this.userobject=this.decoded.UserObject;
        localStorage.setItem('jwt',this.responsetoken.token);
      alert("login success");
      this.role();
      }
    )
  }

  role(){
    this.userservice.commerce_srvce(this.userobject);
    console.log(this.userobject);
  }

}


// npm install jwt-decode --save
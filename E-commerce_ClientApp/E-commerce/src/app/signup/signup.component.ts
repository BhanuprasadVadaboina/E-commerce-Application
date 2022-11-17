import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AppComponent } from '../app.component';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(public userService:UserService,private root:AppComponent) { }

  ngOnInit(): void {
  }

  signupForm=new FormGroup({             
    user_name:new FormControl(''),
    email_id:new FormControl(''),
    password:new FormControl(''),
    address:new FormControl(''),
    phoneNo:new FormControl('')
  })

  signup(){
    this.root.sinup=false;
    this.userService.signup(this.signupForm.value).subscribe(
      response=>{
          alert("signup succesfull");
          console.log(response);
      }
    )
  }

}

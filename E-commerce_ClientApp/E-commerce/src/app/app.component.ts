import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'E-commerce';

  enable:Boolean=false;
  sinup:Boolean=false;

  logout(){
    localStorage.removeItem('jwt');
    alert("Logout sucessfully");
    this.enable=false;
    console.log(localStorage.getItem('jwt'));
  }
  signup(){
    this.sinup=true;
  }
  login(){
    this.enable=true;
  }

}

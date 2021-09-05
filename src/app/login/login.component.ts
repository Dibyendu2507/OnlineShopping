import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: any;
  password: any;
  credential: any;
  userid: any;

  constructor(private service:UserService,private router:Router) { }

  ngOnInit(): void {
  }

  validate(){

    this.credential={
      "username" : this.username,
      "password" : this.password
    }
    let resp = this.service.LoginCheck(this.credential)
    resp.subscribe((data)=>{this.userid=data;
                            this.check();})

  }

  check(){
    if(this.userid != 0){
      localStorage.setItem("userid", this.userid)
      this.router.navigate(['./home']);
    }
  }

}

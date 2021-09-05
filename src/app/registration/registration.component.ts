import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  //user: User = new User("", 0, "", "","", "");
  /*
  name: any;
  contact : any;
  mail : any;
  dob : any;
  username : any;
  password : any
  */
 /*
  form = new FormGroup({
    name: new FormControl('', Validators.required),
    contact: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    mail: new FormControl('', [Validators.required, Validators.email]),
    dob: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });
  */
  message: any;
  user: any;
  resp: any;
  credential: any;
  userid: any;

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    mail: new FormControl('', [Validators.required, Validators.email]),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  public registerNow(){
    
    //console.log(this.form.value.name)
    this.user = {
      "name" : this.form.value.name,
      "mail" : this.form.value.mail,
      "username" : this.form.value.username,
      "password" : this.form.value.password
    }
    let resp=this.service.doRegistration(this.user);
    resp.subscribe( (data)=>{this.resp=data;
                             this.validate();});

  }

  validate(){

    if(this.resp == ""){
      this.credential = {
        "username" : this.user["username"],
        "password" : this.user["password"]
      }
      let resp = this.service.LoginCheck(this.credential)
      resp.subscribe((data)=>{this.userid=data;
                              this.check();})

    }

  }

  check(){
    if(this.userid != 0){
      localStorage.setItem("userid", this.userid)
      this.router.navigate(['./home']);
    }
  }

}

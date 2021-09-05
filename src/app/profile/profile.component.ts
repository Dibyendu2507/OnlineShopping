import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { OrderService } from '../order.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = {
    "name": "",
    "mail": "",
    "username": "",
    "password": "",
    "contact": "",
    "dob": "",
    "address": {
    	"street" : "",
    	"city" : "",
    	"state" : "",
    	"pincode" : "",
    }
  }

  profile: any
  olduserid: any;
  userid : any
  submituser: any
  resp: any
  credential: any
  
  form = new FormGroup({
    name: new FormControl('', Validators.required),
    mail: new FormControl('', [Validators.required, Validators.email]),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    contact: new FormControl('', Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")),
    dob: new FormControl('', ),
    street: new FormControl('', ),
    city: new FormControl('', ),
    state: new FormControl('', ),
    pincode: new FormControl('', )
  });
  
  constructor(private service:UserService, private router:Router, private cartservice:CartService, private historyservice:OrderService) { 

    this.userid = localStorage.getItem("userid");

    if(this.userid==null || this.userid==undefined){
      this.router.navigate(['./home']);
    }

    let resp = service.getProfile(this.userid);
        resp.subscribe((data)=>{this.profile=data;
                                this.getvalues();});

  }

  ngOnInit(): void {
  }

  getvalues(){ 
    this.user = this.profile;
    console.log(this.user)
  }
/*
  getvalues(){
    
    this.user = this.profile

    this.form.value.name = this.user.name
    this.form.value.mail = this.user.mail
    this.form.value.username = this.user.username
    this.form.value.password = this.user.password
    this.form.value.contact = this.user.contact,
    this.form.value.dob = this.user.dob
    this.form.value.street = this.user.address.street,
    this.form.value.city = this.user.address.city,
    this.form.value.state = this.user.address.state,
    this.form.value.pincode = this.user.address.pincode
    console.log(this.form.value.name)
    console.log(this.form.value.mail)
    console.log(this.form.value.username)
    console.log(this.form.value.password)
    console.log(this.form.value.contact)
    console.log(this.form.value.dob)
    console.log(this.form.value.street)
    console.log(this.form.value.city)
    console.log(this.form.value.state)
    console.log(this.form.value.pincode)
  }
*/
  updateProfile(){

    this.submituser = {
      "name": this.form.value.name,
      "mail": this.form.value.mail,
      "username": this.form.value.username,
      "password": this.form.value.password,
      "contact": this.form.value.contact,
      "dob": this.form.value.dob,
      "address": {
    	  "street" : this.form.value.street,
    	  "city" : this.form.value.city,
    	  "state" : this.form.value.state,
    	  "pincode" : this.form.value.pincode
      }
    }

    //let resp = this.service.updateUser(this.submituser, this.userid);
    //resp.subscribe((data)=>{this.resp=data;
                            //this.validate();})
    console.log(this.submituser);
  }

  validate(){

    if(this.resp == ""){

      this.credential = {
        "username" : this.submituser["username"],
        "password" : this.submituser["password"]
      }
      this.olduserid = localStorage.getItem("userid");
      let resp = this.service.LoginCheck(this.credential)
      resp.subscribe((data)=>{this.userid=data;
                              this.check();})

    }

  }

  check(){

    if(this.userid != 0){

      localStorage.setItem("userid", this.userid)
      //let respcart = this.cartservice.updateUserid(this.olduserid, this.userid);
      //respcart.subscribe();
      //let resphistory = this.historyservice.updateUserid(this.olduserid, this.userid);
      //resphistory.subscribe();
      this.router.navigate(['./home']);

    }
    
  }

}


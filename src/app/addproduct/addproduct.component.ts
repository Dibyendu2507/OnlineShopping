import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  message: any;
  product: any;
  resp: any;
  credential: any;
  userid: any;

  form = new FormGroup({
    productid: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    productcategory: new FormControl('', Validators.required),
    imgsrc: new FormControl('', Validators.required),
    rating: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required),
    details: new FormControl('', Validators.required)
  });

  constructor(private service:ProductService, private router:Router) { }

  ngOnInit(): void {
  }

  public saveproduct(){
    
    //console.log(this.form.value.name)
    this.product = {
      "productid" : this.form.value.productid,
      "name" : this.form.value.name,
      "productcategory" : this.form.value.productcategory,
      "imgsrc" : this.form.value.imgsrc,
      "rating" : this.form.value.rating,
      "price" : this.form.value.price,
      "gender" : this.form.value.gender,
      "details" : this.form.value.details

    }
    let resp=this.service.addProduct(this.product);
    resp.subscribe( (data)=>{this.resp=data;});

  }


}

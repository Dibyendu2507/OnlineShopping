import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-productadmin',
  templateUrl: './productadmin.component.html',
  styleUrls: ['./productadmin.component.css']
})
export class ProductadminComponent implements OnInit {

  productid : any;
  products : any;
  userid: any;
  
  productdetails = {
    "productid": "",
    "name": "",
    "productcategory": "",
    "imgsrc": "",
    "rating": "",
    "price": "",
    "gender": "",
    "details": ""
  }
  respproduct: any

  
  form = new FormGroup({
    name: new FormControl('', Validators.required),
    productcategory: new FormControl('', Validators.required),
    imgsrc: new FormControl('', Validators.required),
    rating: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required)
  });

  
  constructor(private productService:ProductService, private cartService:CartService, private router:Router) { 

    this.productid = localStorage.getItem("productid");
    this.userid = localStorage.getItem("userid");  

    let getproductbyid = productService.getProductsById(this.productid);
    getproductbyid.subscribe((data)=>{this.products=data;
                                      this.httpcalls();});

                                
  }

  ngOnInit(): void {

  }

  httpcalls(){
    this.productdetails = this.products
  }

  updateProduct(){
    let resp = this.productService.updateProduct(this.productdetails);
    resp.subscribe((data)=>{this.respproduct=data;
                            this.router.navigate(['./homeadmin']);})
    
  }
  

  counter(i: number) {
    return new Array(i);
  }
  
  signout(){
    localStorage.removeItem("userid");
  }

}

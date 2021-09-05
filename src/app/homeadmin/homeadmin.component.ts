import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-homeadmin',
  templateUrl: './homeadmin.component.html',
  styleUrls: ['./homeadmin.component.css']
})
export class HomeadminComponent implements OnInit {

  products: any;
  filteredprods: any;
  userid: any;
  filterarray: any;
  response: any;
  
  constructor(private productService:ProductService, private cartService:CartService, private router:Router) {

      let getprods = productService.getAllProducts();
      getprods.subscribe((data)=>this.products=data);
      //this.userid = localStorage.getItem("userid");                                

  }
  

  ngOnInit(): void {
    
  }

  counts(){
    this.products
  }

  productpage(productid: any){
    localStorage.setItem("productid", productid)
    console.log(localStorage.getItem("productid"))
  }

  counter(i: number) {
    return new Array(i);
  }

  signout(){
    localStorage.removeItem("userid");
  }


}

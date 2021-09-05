import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  products: any;
  cart: any;
  item: any;
  response: any;
  totalprice: any;
  totalquantity: any;
  userid: any;
  
  constructor(private productService:ProductService, private cartService:CartService, private router:Router) {

    this.userid = localStorage.getItem("userid");  
    if(this.userid==null || this.userid==undefined ){
      this.router.navigate(['./login']);
    }

  }

  ngOnInit(): void {
      this.httpcalls();
  }

  httpcalls(){

      let getprods = this.productService.getAllProducts();
      getprods.subscribe((data)=>{this.products=data;});

      let getitems = this.cartService.getItemsLite(this.userid);
      getitems.subscribe((data)=>{this.cart=data;});

  }

  findtotal(){

      this.totalprice = 0;
      this.totalquantity = 0;
      for(let i=0; i<this.products.length; i++){
          for(let j=0; j<this.cart.length; j++){
              if( this.products[i]["productid"] == this.cart[j]["productid"] ){
                  this.totalprice += this.cart[j]["quantity"]*this.products[i]["price"]
                  this.totalquantity += this.cart[j]["quantity"]
              }
          }
      }
      
  }

  deleteitem(productid: any){

      let deleteitem=this.cartService.deleteItem(this.userid, productid);
      deleteitem.subscribe((data)=>{this.response=data;
                            this.httpcalls();});

  }

  decreseitem(productid: any, quantity:any){

    if( quantity > 0 ){
      this.item = {
        "productid" : productid,
        "quantity" : quantity - 1
      };
      console.log(productid)
      console.log(quantity-1)
      
      let decreseitem=this.cartService.updateItem(this.userid, productid, quantity-1);
      decreseitem.subscribe((data)=>{this.response=data;
                            this.httpcalls();});
    
    }

  }

  increaseitem(productid: any, quantity:any){

    this.item = {
      "productid" : productid,
      "quantity" : quantity + 1
    };
    console.log(productid)
    console.log(quantity+1)
    
    let increaseitem=this.cartService.updateItem(this.userid, productid, quantity+1);
    increaseitem.subscribe((data)=>{this.response=data;
                            this.httpcalls();});
    
  }

  placeorder(){

    let placeorder=this.cartService.placeOrder(this.userid);
    placeorder.subscribe((data)=>{this.response=data;
                            this.httpcalls();});

  }

  removecart(){

    let removecart=this.cartService.deleteCart(this.userid);
    removecart.subscribe((data)=>{this.response=data;
                            this.httpcalls();});

  }

  signout(){
    localStorage.removeItem("userid");
  }

}

/*
let getitem=this.cartService.getItem(productid);
    getitem.subscribe((data)=>{this.itemtable=data;});
    console.log(this.itemtable)
    */
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productid : any;
  products : any;
  item: any;
  cart: any;
  category: any;
  return: any;
  searchstring: any;
  filteredprods: any;
  userid: any;

  
  constructor(private productService:ProductService, private cartService:CartService, private router:Router) { 

    this.productid = localStorage.getItem("productid");
    this.userid = localStorage.getItem("userid");  

    let getproductbyid = productService.getProductsById(this.productid);
    getproductbyid.subscribe((data)=>{this.products=data;
                                      this.httpcalls();});

    let getitems = cartService.getItemsLite(this.userid);
    getitems.subscribe((data)=>{this.cart=data;
                                this.initializeCart()});
                                
  }

  ngOnInit(): void {

  }

  httpcalls(){

  }

  initializeCart(){

    if (this.cart["length"] == 0){
        this.cart = [
            {
                "productid" : "",
                "quantity" : 0
            }
        ];
    }

  }

  addProduct(productid: any){

    console.log(productid);
    if(this.userid==null || this.userid==undefined){
        this.router.navigate(['./login']);
    }

    else{

        for(let i=0; i<this.cart.length; i++){

            if(this.cart[i]["productid"] == productid) {

                this.cart[i]["quantity"] += 1;
                this.item = {
                    "productid" : this.cart[i]["productid"],
                    "quantity" : this.cart[i]["quantity"]
                };
                let updateitem=this.cartService.updateItem(this.userid, productid, this.cart[i]["quantity"]);
                updateitem.subscribe();
                break;
            }

            else if(i == this.cart.length-1){

                this.item = {
                    "productid" : productid,
                    "quantity" : 1
                };
                let additem=this.cartService.addItem(this.userid, productid);
                additem.subscribe();
                this.cart.push(this.item);
                break;

            }

        }

    }
    
  }

  counter(i: number) {
    return new Array(i);
  }
  
  signout(){
    localStorage.removeItem("userid");
  }


}

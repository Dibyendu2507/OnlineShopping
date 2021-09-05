import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: any;
  item: any;
  cart: any;
  category: any;
  return: any;
  searchstring: any;
  filteredprods: any;
  userid: any;
  all: any;
  gents: any;
  ladies: any;
  jeans: any;
  shirts: any;
  isCheckedAll: any;
  isCheckedGents : any;
  isCheckedLadies: any;
  isCheckedJeans: any;
  isCheckedShirt: any;
  filterarray: any;
  response: any;
  minprice: any;
  maxprice: any;
  
  constructor(private productService:ProductService, private cartService:CartService, private router:Router) {

      let getprods = productService.getAllProducts();
      getprods.subscribe((data)=>this.products=data);

      this.userid = localStorage.getItem("userid");  
      
      let getitems = cartService.getItemsLite(this.userid);
      getitems.subscribe((data)=>{this.cart=data;
                                  this.initializeCart()});                               

  }
  

  ngOnInit(): void {
    
  }

  checkValueGents(event: any){
    this.gents= event;
    this.filter();
  }
  checkValueLadies(event: any){
    this.ladies = event;
    this.filter();
  }
  checkValueJeans(event: any){
    this.jeans = event;
    this.filter();
  }
  checkValueShirt(event: any){
    this.shirts = event;
    this.filter();
  }

  filter(){
    
    this.filterarray = {
      "gents" : this.gents,
      "ladies" : this.ladies,
      "jeans" : this.jeans,
      "shirts" : this.shirts
    }
    console.log(this.filterarray);
    let resp = this.productService.getProductsByfilter(this.filterarray);
    resp.subscribe((data)=>{this.products=data;
                            })
  
  }

  searchByPrice(){
    let resp = this.productService.getProdutsByPrice(this.minprice, this.maxprice);
    resp.subscribe((data)=>{this.products=data;
                            })
  }

  Search(searchstring:any){
    let resp = this.productService.getProductsBysearchString(searchstring);
    resp.subscribe((data)=>{this.products=data;
                                        });
  }

  counts(){
    this.products
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

  // All(){
  //   this.category = "";
  //   let AllProducts = this.productService.getAllProducts();
  //   AllProducts.subscribe((data)=>this.products=data);
  // }

  // Gents(){
  //   this.category = "male";
  //   let filteredProducts = this.productService.getProductsByCategory(this.category);
  //   filteredProducts.subscribe((data)=>{this.products=data;});
  // }

  // Ladies(){
  //   this.category = "female";
  //   let filteredProducts = this.productService.getProductsByCategory(this.category);
  //   filteredProducts.subscribe((data)=>{this.products=data;});
  // }

  // Jeans(){
  //   this.category = "jeans";
  //   let filteredProducts = this.productService.getProductsByCategory(this.category);
  //   filteredProducts.subscribe((data)=>{this.products=data;});
  // }

  // Shirts(){
  //   this.category = "shirt";
  //   let filteredProducts = this.productService.getProductsByCategory(this.category);
  //   filteredProducts.subscribe((data)=>{this.products=data;});
  // }




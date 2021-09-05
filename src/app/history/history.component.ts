import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { OrderService } from '../order.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  products: any;
  orders: any;
  item: any;
  response: any;
  userid: any;
  
  constructor(private productService:ProductService, private historytService:OrderService, private router:Router) {

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

      let getitems = this.historytService.getItemsLite(this.userid);
      getitems.subscribe((data)=>{this.orders=data;});

  }

  removehistory(){

    let removehistory=this.historytService.deleteHistory(this.userid);
    removehistory.subscribe((data)=>{this.response=data;
                            this.httpcalls();});

  }

  signout(){
    localStorage.removeItem("userid");
  }

}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }

  public getItems(userId: any){
    return this.http.get("http://localhost:8080/cart/" + userId + "/getCart");
  }

  public getItemsLite(userId: any){
    return this.http.get("http://localhost:8080/cart/" + userId + "/getCartLite");
  }

  public addItem(userId: any, productId: any){
    return this.http.get("http://localhost:8080/cart/" + userId + "/add/" + productId);
  }

  public updateItem(userId: any, productId: any, quantity: any){
    return this.http.put("http://localhost:8080/cart/" + userId + "/changeQuantity/" + productId, quantity, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
    });
  }

  public deleteItem(userId: any, productId: any){
    return this.http.delete("http://localhost:8080/cart/" + userId + "/remove/" + productId);
  }

  public deleteCart(userId: any){
    return this.http.delete("http://localhost:8080/cart/" + userId + "/deleteCart");
  }

  public placeOrder(userId: any){
    return this.http.post("http://localhost:8080/cart/" + userId + "/placeOrder", {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
    });
  }

  public updateUserid(olduserId: any, newuserId: any){
    return this.http.get("http://localhost:8080/cart/" + olduserId + "/updateUserid/" + newuserId);
  }


}

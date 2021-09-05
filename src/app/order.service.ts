import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  public getItems(userId: any){
    return this.http.get("http://localhost:8080/order/" + userId + "/getOrders");
  }

  public getItemsLite(userId: any){
    return this.http.get("http://localhost:8080/order/" + userId + "/getOrdersLite");
  }

  public deleteHistory(userId: any){
    return this.http.delete("http://localhost:8080/order/" + userId + "/deleteHistory");
  }

  public updateUserid(olduserId: any, newuserId: any){
    return this.http.get("http://localhost:8080/order/" + olduserId + "/updateUserid/" + newuserId);
  }

}

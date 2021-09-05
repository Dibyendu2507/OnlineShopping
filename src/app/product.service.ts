import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public getAllProducts(){
    return this.http.get("http://localhost:8080/products/all");
  }

  public getProductsByCategory(category: any){
    return this.http.get("http://localhost:8080/products/" + category);
  }

  public getProductsBysearchString(searchString: any){
    return this.http.get("http://localhost:8080/products/search/" + searchString);
  }

  public getProductsById(productId: any){
    return this.http.get("http://localhost:8080/products/getById/" + productId);
  }

  public getProductsByfilter(filterarray: any){
    return this.http.post("http://localhost:8080/products/getFilteredProducts" , filterarray)
  }

  public getProdutsByPrice(minprice: any, maxprice: any){
    return this.http.get("http://localhost:8080/products/" + minprice + "/to/" + maxprice);
  }

  public updateProduct(product: any){
    return this.http.put("http://localhost:8080/products/update" , product)
  }

  public addProduct(product: any){
    return this.http.post("http://localhost:8080/products/addProduct" , product)
  }

}

//{responseType: 'text'}
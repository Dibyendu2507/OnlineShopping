import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  public doRegistration(user: any){
    return this.http.post("http://localhost:8080/signup", user, {responseType: 'text'});
  }

  public LoginCheck(credential: any){
    return this.http.post("http://localhost:8080/login", credential);
  }

  public getProfile(userid: any){
    return this.http.get("http://localhost:8080/getprofile/" + userid);
  }

  public updateUser(user: any, userid: any){
    return this.http.put("http://localhost:8080/update/" + userid, user, {responseType: 'text'});
  }

}

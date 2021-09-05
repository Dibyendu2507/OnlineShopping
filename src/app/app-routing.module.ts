import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddproductComponent } from './addproduct/addproduct.component';
import { CartComponent } from './cart/cart.component';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { HomeadminComponent } from './homeadmin/homeadmin.component';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { ProductadminComponent } from './productadmin/productadmin.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path:"",redirectTo:"home",pathMatch:"full"},
  {path:"home", component:HomeComponent},
  {path:"register", component:RegistrationComponent},
  {path:"cart", component:CartComponent},
  {path:"product", component:ProductComponent},
  {path:"login", component:LoginComponent},
  {path:"history", component:HistoryComponent},
  {path:"profile", component:ProfileComponent},
  {path:"homeadmin", component:HomeadminComponent},
  {path:"productadmin", component:ProductadminComponent},
  {path:"addproduct", component:AddproductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

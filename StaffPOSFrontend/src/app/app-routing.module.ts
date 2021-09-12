import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { StaffdashboardComponent } from './staffdashboard/staffdashboard.component';
const routes: Routes = [
  {
    path:'staffdashboard',
    component: StaffdashboardComponent
  },
  
  {
    path:'product',
    component:ProductComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'',
    component: LoginComponent
  },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

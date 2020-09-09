import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import {Admin} from './Admin'
import {Router} from '@angular/router'
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  constructor(private service:LoginService,private router:Router) { }

  ngOnInit(): void {

  }
  Admin = new Admin();
  message:string;
  adminLogin(){
    this.service.loginAdmin(this.Admin).subscribe(data =>{
      alert(JSON.stringify("Admin Signing in..."));
      if(data.status == 'SUCCESS'){
        let adminId=data.adminId;
        let adminName=data.adminName;
        sessionStorage.setItem('adminId',String(adminId));
        sessionStorage.setItem('adminName',adminName);
        this.router.navigate(['/adminPortal']);
      }
      else{
        this.message=data.message;
      }
    })
  }
}

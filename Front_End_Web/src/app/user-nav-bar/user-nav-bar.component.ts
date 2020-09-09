import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'app-user-nav-bar',
  templateUrl: './user-nav-bar.component.html',
  styleUrls: ['./user-nav-bar.component.css']
})
export class UserNavBarComponent implements OnInit {
  getDatetime = new Date();
  customerName:string;
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.customerName = sessionStorage.getItem('customerName');
  }

  logout()
  {
    sessionStorage.removeItem("customerName");
    sessionStorage.removeItem("customerId");
    this.router.navigate(['/logout']);
  }

}

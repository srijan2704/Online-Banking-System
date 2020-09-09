import { Component, OnInit } from '@angular/core';
import { Input } from "@angular/core";
import {CustomerId} from '../transactions/CustomerId';
import {UserProfileService} from '../user-profile.service'
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  customerId = new CustomerId();
  userProfile:any;
  constructor(private service:UserProfileService) {
   
   }

  ngOnInit(): void {
    this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service.getUserProfile(this.customerId).subscribe(data=>
      {
        this.userProfile = data;
      //  alert(JSON.stringify(this.userProfile));
      })
    
    }
}

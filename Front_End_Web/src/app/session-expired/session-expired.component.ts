import { Component, OnInit } from '@angular/core';
import { LocationStrategy } from '@angular/common';
@Component({
  selector: 'app-session-expired',
  templateUrl: './session-expired.component.html',
  styleUrls: ['./session-expired.component.css']
})
export class SessionExpiredComponent implements OnInit {

  constructor(private location: LocationStrategy) {
    
   }

  ngOnInit(): void {
  }

}

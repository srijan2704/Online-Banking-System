import { Component, OnInit } from '@angular/core';
import { LocationStrategy } from '@angular/common';
@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit {

  constructor(private location: LocationStrategy) {
    history.pushState(null, null, window.location.href);  
    this.location.onPopState(() => {
    alert(JSON.stringify("Cann't Go back!"));
    history.pushState(null, null, window.location.href);
    }); 
   }

  ngOnInit(): void {
  }

}

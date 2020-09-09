import { Component, OnInit } from '@angular/core';
import { LocationStrategy } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-dash-board',
  templateUrl: './admin-dash-board.component.html',
  styleUrls: ['./admin-dash-board.component.css']
})
export class AdminDashBoardComponent implements OnInit {
  getDatetime = new Date();
  adminName: string;
  path = "/My Account & Profile"
  constructor(private location: LocationStrategy, private router: Router) {
    history.pushState(null, null, window.location.href);
    this.location.onPopState(() => {
      history.pushState(null, null, window.location.href);

    });
  }

  ngOnInit(): void {
    this.adminName = sessionStorage.getItem('adminName');
  }

  logout() {
    sessionStorage.removeItem("adminName");
    sessionStorage.removeItem("adminId");
    this.router.navigate(['/logout']);
  }

}

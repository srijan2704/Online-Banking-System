import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service'
import { Login } from './Login'
import { Router } from '@angular/router'
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../main.css']
})
export class LoginComponent implements OnInit {
  counter: number = 3;
  constructor(private service: LoginService, private router: Router) {



  }

  ngOnInit(): void {

    var input: HTMLInputElement = document.querySelector('.pswrd');
    var show: HTMLInputElement = document.querySelector('.show');
    show.addEventListener('click', active);
    function active() {
      if (input.type === "password") {
        input.type = "text";
        show.style.color = "#1DA1F2";
        show.textContent = "HIDE";
      }
      else {
        input.type = "password";
        show.textContent = "SHOW";
        show.style.color = "#111";
      }
    }

  }
  Login = new Login();
  message: string;
  val = 0;
  loginUser() {
    if (this.counter === 1) {
      this.router.navigate(["/accountLocked"]);
    }
    this.service.login(this.Login).subscribe(data => {
      console.log(data.message);
      this.message = data.message;
      if (data.status == 'SUCCESS') {
        let customerId = data.customerId;
        let name = data.customerFirstName;
        sessionStorage.setItem('customerId', String(customerId));
        sessionStorage.setItem('customerName', name);
        this.router.navigate(['/userDashboard']);
        localStorage.setItem("userId", String(this.Login.customerId));
        localStorage.setItem("password", this.Login.loginPassword);
        console.log(this.message);
      }
      else {
        this.message = data.message;

      }
    })
    console.log(this.val);
    if (this.val === 0) {
      this.message = "Invalid UserId/Password";
      this.counter--;
    }
    else {

    }
    console.log(this.counter);
  }

  cookiesStorage() {
    this.Login.customerId = Number(localStorage.getItem("userId"));
    this.Login.loginPassword = localStorage.getItem("password");
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from './login/Login'
import {LoginStatus} from './login/LoginStatus'
import { LoginComponent } from './login/login.component';
import { Observable } from 'rxjs';
import {Admin} from './admin-login/Admin';
import {AdminLoginStatus} from './admin-login/AdminLoginStatus'
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  login(login:Login) :Observable<LoginStatus>
  {
    return this.http.post<LoginStatus>('http://localhost:8080/login',login);
  }

  loginAdmin(admin:Admin) :Observable<AdminLoginStatus>
  {
    return this.http.post<AdminLoginStatus>('http://localhost:8080/loginAdmin',admin);
  }
}

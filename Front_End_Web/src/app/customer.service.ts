import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ResetCheck } from "./dto-classes/ResetCheck";
import { Otp } from "./dto-classes/Otp";
import { Observable } from "rxjs";
import { Status } from "./dto-classes/Status";
import { ResetPass } from "./dto-classes/ResetPass";
import {DashPassword} from './dto-classes/DashPassword';
@Injectable({
  providedIn: 'root'
})
export class ForgetPasswordService {

  constructor(private http:HttpClient) { }

  send(resetCheck:ResetCheck){
    return this.http.post('http://localhost:8080/forgetPasswordLink',resetCheck);
  }

  validate(otp:Otp):Observable<Status>{
    return this.http.post<Status>('http://localhost:8080/checkotp',otp)
  }

  setPass(resetPass:ResetPass):Observable<Status>{
    return this.http.post<Status>('http://localhost:8080/setPaaswordLink',resetPass)
  }

  setDashPass(dashPassword:DashPassword):Observable<Status>{
    return this.http.post<Status>('http://localhost:8080/dashSetPaaswordLink',dashPassword);
  }

}

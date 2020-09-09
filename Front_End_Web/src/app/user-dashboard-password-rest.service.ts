import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { DashPassword } from "./dto-classes/DashPassword";
import { Observable } from "rxjs";
import { Status } from "./dto-classes/Status";
@Injectable({
  providedIn: 'root'
})
export class UserDashboardPasswordRestService {

  constructor(private http:HttpClient) { }

  setDashPass(dashPassword:DashPassword):Observable<Status>{
    return this.http.post<Status>('http://localhost:8080/dashSetPaaswordLink',dashPassword);
  }

}

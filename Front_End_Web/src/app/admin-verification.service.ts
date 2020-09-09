import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ReferenceNo } from "./reference-no";

@Injectable({
  providedIn: 'root'
})
export class AdminVerificationService {

  constructor(private http:HttpClient) { }

  getVisitors(){
    return this.http.get('http://localhost:8080/viewVisitors');
   }

   deleteVisitor(srn:ReferenceNo){
      return this.http.post('http://localhost:8080/DeleteVisitorByRef',srn);
   }

   addCustomer(srn:ReferenceNo){
     return this.http.post('http://localhost:8080/createCustomerWithVisitor',srn);
   }
}

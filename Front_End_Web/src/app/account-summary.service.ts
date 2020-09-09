import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {CustomerId} from './transactions/CustomerId';
@Injectable({
  providedIn: 'root'
})
export class AccountSummaryService {

  constructor(private http:HttpClient) { }

  getAccountSummary(customerId:CustomerId): Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/accountSummary',customerId);
  }
}

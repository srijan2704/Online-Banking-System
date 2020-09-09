import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {TransactionDetail} from './transactions/transactionsDetails';
import {CustomerId} from './transactions/CustomerId';
@Injectable({
  providedIn: 'root'
})
export class TransactionDetailService {

  constructor(private http:HttpClient) { }

  getTransactionDetails(customerId:CustomerId): Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/miniStatement',customerId);
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Transaction} from './dto-classes/transaction'
@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http:HttpClient) { }

  getTransactionDetails(transaction:Transaction): Observable<any>
  {
    return this.http.put<any>('http://localhost:8080/makeTransaction',transaction);
  }
}

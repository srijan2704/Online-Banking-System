import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {accountStatement} from './account-statement/accountStatement';
@Injectable({
  providedIn: 'root'
})
export class AccountStatementService {

  constructor(private http:HttpClient) { }

  getAccountStatement(accountStatement:accountStatement): Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/accountStatement',accountStatement);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AddBeneficiary} from './dto-classes/AddBeneficiary';
import {Addbeneficiarymessage} from './dto-classes/addbeneficiarymessage'
import { CustomerId } from './transactions/CustomerId';
import {CustomerIdGet} from './add-beneficiary/CustomerIdGet';
import {GetBeneficiary} from './dto-classes/getBeneficiaryDetails'
@Injectable({
  providedIn: 'root'
})
export class AddBeneficiaryService {

  constructor(private http:HttpClient) { }

  addBeneficiary(addBeneficiary:AddBeneficiary):Observable<Addbeneficiarymessage>
  {
    return this.http.post<Addbeneficiarymessage>('http://localhost:8080/addBeneficiary',addBeneficiary);
  }

  getBeneficiaryList(customerId:CustomerIdGet):Observable<GetBeneficiary>
  {
    return this.http.post<GetBeneficiary>('http://localhost:8080/getBeneficiaryList',customerId);
  }
}

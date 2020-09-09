import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Complaint } from './complaint/Complaint';
import {ComplaintStatus  } from './complaint-status/ComplaintStatus';
import { ComplaintNo } from './complaint-status/ComplaintNo';
import { ComplaintNo1 } from './complaint-approval/ComplaintNo1';
@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private http:HttpClient) { }

  addComplaint(complaint:Complaint)
  {
    return this.http.post('http://localhost:8080/complaint',complaint);
  }
  getComplaints(){
    return this.http.get('http://localhost:8080/viewComplaints');
  }
  checkVisitorStatus(ComplainNumber: ComplaintNo):Observable<ComplaintStatus>
  {
    return this.http.post<ComplaintStatus>("http://localhost:8080/checkComplaintStatus",ComplainNumber);
  }

  updateStatus(complaintNo:ComplaintNo1){
   return this.http.post("http://localhost:8080/changeStatus",complaintNo)
  }
}

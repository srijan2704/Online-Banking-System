import { Component, OnInit } from '@angular/core';
import { ReferenceNo } from '../reference-no';
import { VisitorServiceService } from "../visitor-service.service";
import { VisitorStatus } from "./visitor-status";

@Component({
  selector: 'app-visitor-status',
  templateUrl: './visitor-status.component.html',
  styleUrls: ['./visitor-status.component.css']
})
export class VisitorStatusComponent implements OnInit {

  visitorStatus:VisitorStatus;
  refNo = new ReferenceNo();

  constructor(private visitorService:VisitorServiceService) { }

  ngOnInit(): void {
  }

  showStatus()
  {
      this.visitorService.checkVisitorStatus(this.refNo).subscribe(visitorStatus=>{
        this.visitorStatus = new VisitorStatus();
        this.visitorStatus.serialRefNo = this.refNo.serviceRefNo;
        this.visitorStatus.status = visitorStatus.status;
      }
      )
  }
}


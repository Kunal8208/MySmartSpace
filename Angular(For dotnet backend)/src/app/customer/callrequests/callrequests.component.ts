import { Component, Input, OnInit } from '@angular/core';
import { NewRequest } from 'src/app/newRequest.model';
import { ProductserviceService } from 'src/app/productservice.service';
import { Quotation } from 'src/app/Quotation.model';
import { User } from 'src/app/User.model';

@Component({
  selector: 'app-callrequests',
  templateUrl: './callrequests.component.html',
  styleUrls: ['./callrequests.component.css']
})
export class CallrequestsComponent implements OnInit {

  customer:User=JSON.parse(sessionStorage["user_dtls"]);
  allRequests:[];
  quotationViewFlag:boolean=false;
  quotationDetailFlag:boolean=false;
  allQuotations:[];
  selectedQuotation:Quotation;
  selectedRequest:NewRequest;

  constructor(private prodService:ProductserviceService) { }

  ngOnInit(): void {
    this.prodService.showAllRequestsForParticularUser(this.customer.UserId).subscribe(data=>this.allRequests=data, err=>console.log(err));
  }

  getStatus(request:NewRequest){
    if(request.IsValid==true){
      return "Pending";
    }
    else{
      return "Order completed";
    }
  }

  getClass(request:NewRequest){
    if(request.IsValid==true){
      return "badge badge-danger";
    }
    else{
      return "badge badge-success";
    }
  }

  viewQuotations(request:NewRequest){
    this.selectedRequest=request;
    this.prodService.getAllQuotations(request.RequestId).subscribe(data=>this.allQuotations=data, err=>console.log(err));
    this.quotationViewFlag=true;
  }

  selectQuotation(quotation:Quotation){
    this.quotationDetailFlag=true;
    this.selectedQuotation=quotation;
  }

}

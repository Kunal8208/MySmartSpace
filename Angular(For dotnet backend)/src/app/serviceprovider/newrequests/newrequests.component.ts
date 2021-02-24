import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { NewRequest } from 'src/app/newRequest.model';
import { ProductserviceService } from 'src/app/productservice.service';
import { User } from 'src/app/User.model';

@Component({
  selector: 'app-newrequests',
  templateUrl: './newrequests.component.html',
  styleUrls: ['./newrequests.component.css']
})
export class NewrequestsComponent implements OnInit {

  serviceProvider:User=JSON.parse(sessionStorage["user_dtls"]);
  newRequestsWithoutQuotationSent:[];
  selectedRequest:NewRequest;
  showRequestDetails:boolean=false;

  constructor(private prodService:ProductserviceService, private route :ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.prodService.getNewRequestsWithoutQuotationSent(this.serviceProvider.UserId).subscribe(
      data=>this.newRequestsWithoutQuotationSent=data,
      err=>console.log(err)
    )
  }


  viewRequestDetails(newRequest:NewRequest){
    this.selectedRequest=newRequest;
    this.showRequestDetails=true;
  }

  cancelDetailView(flag:boolean){
    this.showRequestDetails=false;
  }

}

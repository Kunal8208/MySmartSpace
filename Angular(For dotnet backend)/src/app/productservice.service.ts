import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewRequest } from './newRequest.model';
import { Order } from './Order.model';
import { Product } from './product.model';
import { Quotation } from './Quotation.model';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  /*
  baseUrl:string="http://localhost:8282/products/";
  baseNewRequestUrl="http://localhost:8282/newrequest/";
  baseQuotationUrl="http://localhost:8282/quotations/";
  baseOrderUrl="http://localhost:8282/orders/";
  basePaymentUrl="http://localhost:8282/payments/";
  */

  baseUrlProducts="http://localhost:64734/products/";
  baseUrlProductscategory="http://localhost:64734/Productscategory/";
  baseUrlProductsForServiceProvider="http://localhost:64734/ProductsForServiceProvider/";
  

  baseUrlNewRequest="http://localhost:64734/Newrequest/";
  baseUrlUserRequest="http://localhost:64734/UserRequest/";
  baseUrlNewRequestWithoutQuotationsSent="http://localhost:64734/NewRequestWithoutQuotationsSent/";
  

  baseUrlQuotations="http://localhost:64734/Quotations/";
  baseUrlQuotationsForRequest="http://localhost:64734/QuotationForRequest/";
  baseUrlQuotationReject="http://localhost:64734/QuotationReject/";
  baseUrlQuotationAccept="http://localhost:64734/QuotationAccept/";
  baseUrlQuotationsForServiceProvider="http://localhost:64734/QuotationsForServiceProvider/";

  baseUrlOrders="http://localhost:64734/Orders/";
  baseUrlOrdersForCustomer="http://localhost:64734/OrdersForCustomers/";
  baseUrlOrdersForServiceProvider="http://localhost:64734/OrdersForServiceProvider/";

  baseUrlPayments="http://localhost:64734/Payments/";



  constructor(private http:HttpClient) { }

  getAllProducts():Observable<any>{
    return this.http.get(this.baseUrlProducts);
    //http://localhost:64734/products/
  }

  getProductById(id:number):Observable<any>{
    return this.http.get(this.baseUrlProducts + id);
    //http://localhost:64734/products/1
  }

  addProduct(product:Product):Observable<any>{
    return this.http.post(this.baseUrlProducts, product);
  }

  getProductsByCategory(category:string):Observable<any>{
    let categoryId:number;
    switch(category){
      case "DOOR": categoryId=0;
      break;
      case "WINDOW": categoryId=1;
      break;
    }
    return this.http.get(this.baseUrlProductscategory + categoryId);
    //http://localhost:64734/productscategory/1
  }

  getAllProductCategories():Observable<any>{
    return this.http.get(this.baseUrlProductscategory);
  }








  getRequestById(requestId:number):Observable<any>{
    return this.http.get(this.baseUrlNewRequest + requestId);
    //NewrequestController
  }


  submitNewRequest(newRequest:NewRequest):Observable<any>{
    return this.http.post(this.baseUrlNewRequest, newRequest);
    //NewrequestController
  }

  showAllRequestsForParticularUser(userId:number):Observable<any>{
    return this.http.get(this.baseUrlUserRequest + userId);
    //UserRequestController
  }

  getAllQuotations(requestId:number):Observable<any>{
    return this.http.get(this.baseUrlQuotationsForRequest + requestId);
  }









  rejectQuotation(quotation:Quotation):Observable<any>{
    return this.http.get(this.baseUrlQuotationReject + quotation.QuotationId);
  }

  acceptQuotation(quotation:Quotation):Observable<any>{
    return this.http.get(this.baseUrlQuotationAccept + quotation.QuotationId);
  }

  submitNewQuotation(newQuotation:Quotation):Observable<any>{
    return this.http.post(this.baseUrlQuotations, newQuotation);
  }

  getAllQuotationsSentForServiceProvider(serviceProviderId):Observable<any>{
    return this.http.get(this.baseUrlQuotationsForServiceProvider + serviceProviderId);
  }









  placeOrder(newOrder:Order):Observable<any>{
    return this.http.post(this.baseUrlOrders, newOrder);
  }

  getOrderById(orderId:number):Observable<any>{
    return this.http.get(this.baseUrlOrders + orderId);
  }

  getOrders(customerId:number):Observable<any>{
    return this.http.get(this.baseUrlOrdersForCustomer + customerId);
  }

  getOrdersByServiceProviderId(serviceProviderId):Observable<any>{
    return this.http.get(this.baseUrlOrdersForServiceProvider + serviceProviderId);
  }







  getservedProductsforServiceProvider(serviceProviderId:number):Observable<any>{
    return this.http.get(this.baseUrlProductsForServiceProvider + serviceProviderId);
  }

  getNewRequestsWithoutQuotationSent(serviceProviderId:number):Observable<any>{
    return this.http.get(this.baseUrlNewRequestWithoutQuotationsSent + serviceProviderId);
  }




  insertPayment(newPayment):Observable<any>{
    return this.http.post(this.baseUrlPayments, newPayment);
  }


}

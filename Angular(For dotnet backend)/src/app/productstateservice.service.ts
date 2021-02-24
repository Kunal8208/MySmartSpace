import { Injectable } from '@angular/core';
import { NewRequest } from './newRequest.model';
import { Product } from './product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductstateserviceService {

  public productState:Product;
  newRequestObj:NewRequest;

  constructor() { }

}

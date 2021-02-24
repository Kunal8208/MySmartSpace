import { Injectable } from '@angular/core';
import { User } from './User.model';

@Injectable({
  providedIn: 'root'
})
export class LoginstateserviceService {

  loginStatus:boolean=false;
  user:User;

  constructor() { }
}

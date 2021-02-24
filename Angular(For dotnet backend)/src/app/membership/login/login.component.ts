import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { User } from 'src/app/User.model';
import { MembershipService } from '../membership.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:String;
  password:String;
  invalidFlag:boolean=false;
  user:User;
  allUsers:any;
  registerFlag:boolean=false;


  constructor(public ms:MembershipService, private route : ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.ms.validateUser(this.email, this.password).subscribe(
      data=>{
        console.log("Data: "+data.firstName);
        if(data==null){
          this.invalidFlag=true;
        }
        else{
          this.user=data;
          alert("USEr: "+this.user);
          sessionStorage['login_status'] = 1;
          sessionStorage.setItem("user_dtls", JSON.stringify(this.user));
          this.ms.loginStatus=true;
          this.ms.user=this.user;
          this.invalidFlag=false;

          alert("ROLE: "+this.user.FirstName);

          if(this.user.Role == 1){
            this.router.navigate(['/customer']);
          }
          else if(this.user.Role == 2){
            this.router.navigate(['/serviceprovider']);
          }
          else if(this.user.Role == 0){
            this.router.navigate(['/admin']);
          }
        }
      }, 
      err=>{
        alert("ERROR");
        console.log(err);
        this.invalidFlag=true;
      });
  }

  goToRegistration(){
    this.registerFlag=true;
   // this.router.navigate(["/register"]);
  }

  resetRegisterFlag(event:Event){
    this.registerFlag=false;
  }

}

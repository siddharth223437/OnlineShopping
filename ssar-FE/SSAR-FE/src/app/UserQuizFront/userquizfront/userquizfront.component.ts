import { UserRegister } from '../../Register/register/userregister';
import { AllService } from '../../Services/all.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userquizfront',
  templateUrl: './userquizfront.component.html',
  styleUrls: ['./userquizfront.component.css']
})
export class UserquizfrontComponent implements OnInit {
  
  model = new UserRegister();
  public questionResp;
  constructor(private allService: AllService,private router: Router) { }

  ngOnInit() {
  }
  
  verifyUser(){
    this.allService.verifyUser(this.model.userEmail,this.model.userCode).subscribe(
    (resp) => {
      const userResp = resp['status'];
      if(userResp){
        localStorage.setItem('userEmail',this.model.userEmail);
        localStorage.setItem('userCode',this.model.userCode);
        this.router.navigate(['/questions']);
      }
    }
    );
    
  }

}

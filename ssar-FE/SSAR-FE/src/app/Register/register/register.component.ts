import {AllService} from '../../Services/all.service';
import {UserRegister} from './userregister';
import {Component, OnInit} from '@angular/core';
import {ViewChild} from '@angular/core';
import {NgbTypeahead} from '@ng-bootstrap/ng-bootstrap';
import {Subject, Observable} from 'rxjs';

import {debounceTime, distinctUntilChanged, filter, map, merge} from 'rxjs/operators';

const states = ['Alabama', 'Alaska', 'American Samoa', 'Arizona', 'Arkansas', 'California', 'Colorado',
  'Connecticut', 'Delaware', 'District Of Columbia', 'Federated States Of Micronesia', 'Florida', 'Georgia',
  'Guam', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine',
  'Marshall Islands', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana',
  'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
  'Northern Mariana Islands', 'Ohio', 'Oklahoma', 'Oregon', 'Palau', 'Pennsylvania', 'Puerto Rico', 'Rhode Island',
  'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virgin Islands', 'Virginia',
  'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public techno = [];
  model = new UserRegister();
  registerUserResp;
  constructor(private allService: AllService) {}

  ngOnInit() {
    this.showAllStreams();
    localStorage.setItem('compId','1');
  }

  showAllStreams() {
    this.allService.getAllStream().subscribe(
      (resp) => {
        const newResp = [] = resp['responseObject'];

        for (let i = 0; i < newResp.length; i++) {
          this.techno.push(newResp[i]);
        }
      }
    );
  }

  registerUser() {
    console.log('username is ', this.model.userEmail);
    console.log('tech is ', this.model.tech);
    
    const techName = this.model.tech;

    let techId = '';
    for (let i = 0; i < this.techno.length; i++) {
      if (techName.match(this.techno[i].technology)) {
        techId = this.techno[i].streamID;
      }
    }

    this.allService.registerUser(localStorage.getItem('compId'),techId,this.model.userEmail).subscribe(
    (resp) => {
      this.registerUserResp = resp['responseObject'];
    }
    );
    
  }

}

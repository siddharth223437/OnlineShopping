import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';

@Injectable()
export class AllService {

  constructor(private httpClient: HttpClient) { }

  Local_URL = 'http://localhost:7070/ssar/';
 
 
  getAllStream() {
    return this.httpClient.get(this.Local_URL + 'stream/allstream/').map(
    (response) => response
    );
  }
  
  // to be implemented, currently setting hardcodded values
  holdCompanyDetails() {
    // value is set in register component
  }
  
  registerUser(companyId,StreamId,email) {
    return this.httpClient.get(this.Local_URL + 'user/register/' + companyId + '/' + StreamId + '/' + email).map(
    (response) => response
    );
  }
  
  displayQuestionService(email,code){
    return this.httpClient.get(this.Local_URL + 'user/ques/' + email +'/' + code).map(
    (response) => response
    );
  }
  
  verifyUser(email,code){
     return this.httpClient.get(this.Local_URL + 'user/checkUser/' +email + '/' + code).map(
     (response) => response
     );
  }
  
  sendQuesOpt(optLst : any){
    return this.httpClient.post(this.Local_URL + 'user/opt/',optLst ).map(
    (response) => response
    );
    
  }

}

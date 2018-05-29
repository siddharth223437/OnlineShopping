import {AllService} from '../../Services/all.service';
import {QuestionOp} from './questionop';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  public questionsArr = [];
  public questionIdAndOptionId: string;
  model = new QuestionOp();
  public dis = true;

  public submitOpt = [];
  public holdPrev: string;
  constructor(private allService: AllService) {}

  ngOnInit() {
    this.allQuestions();
  }

  allQuestions() {
    this.allService.displayQuestionService(localStorage.getItem('userEmail'), localStorage.getItem('userCode')).subscribe(
      (resp) => {
        const quesResp = resp['responseObject'];
        const optionResp = '';
        for (let i = 0; i < quesResp.length; i++) {
          this.questionsArr.push(quesResp[i]);
        }
      }
    );
  }

  submitAns(ind, questionId) {
    console.log('question id is ', questionId);
    console.log('option id is ', this.model.opId);
    console.log('index is ', ind);

    console.log('pushed into optionArr ', this.submitOpt);

  }

  disableBut(i) {

  }

  storeOptionId(questionId, optionId) {
    this.model.opId = optionId;
    this.submitOpt.push(questionId + '#' + this.model.opId); 
    
  }

  finalSubmit() {
    this.allService.sendQuesOpt(this.submitOpt).subscribe(
    (response) => console.log(response)
    );
    console.log(this.submitOpt);
    this.submitOpt = [];
    console.log('size of arr', this.submitOpt.length);
  }
  

}

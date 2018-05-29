import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, FormGroup, FormControl} from '@angular/forms';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header/header.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';

import {routes} from './app.router';
import { RegisterComponent } from './Register/register/register.component';
import { HomeComponent } from './Home/home/home.component';
import { AllService } from './Services/all.service';
import { TesthomeComponent } from './testhome/testhome.component';
import { UserquizfrontComponent } from './UserQuizFront/userquizfront/userquizfront.component';
import { QuestionsComponent } from './QuestionsWithOptions/questions/questions.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegisterComponent,
    HomeComponent,
    TesthomeComponent,
    UserquizfrontComponent,
    QuestionsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    routes,
    NgbModule.forRoot()
  ],
  providers: [
  AllService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}

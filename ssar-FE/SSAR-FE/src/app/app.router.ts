import {HomeComponent} from './Home/home/home.component';
import { QuestionsComponent } from './QuestionsWithOptions/questions/questions.component';
import {RegisterComponent} from './Register/register/register.component';
import { UserquizfrontComponent } from './UserQuizFront/userquizfront/userquizfront.component';
import { TesthomeComponent } from './testhome/testhome.component';
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

export const router: Routes = [

  {path: '', redirectTo: 'testhome', pathMatch: 'full'},

  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'testhome', component: TesthomeComponent},
  {path : 'userquiz', component: UserquizfrontComponent},
  {path: 'questions', component: QuestionsComponent}

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);

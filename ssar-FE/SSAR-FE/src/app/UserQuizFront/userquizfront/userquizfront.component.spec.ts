import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserquizfrontComponent } from './userquizfront.component';

describe('UserquizfrontComponent', () => {
  let component: UserquizfrontComponent;
  let fixture: ComponentFixture<UserquizfrontComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserquizfrontComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserquizfrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

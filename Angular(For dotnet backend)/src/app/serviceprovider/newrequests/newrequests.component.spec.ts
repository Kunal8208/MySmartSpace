import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewrequestsComponent } from './newrequests.component';

describe('NewrequestsComponent', () => {
  let component: NewrequestsComponent;
  let fixture: ComponentFixture<NewrequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewrequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewrequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

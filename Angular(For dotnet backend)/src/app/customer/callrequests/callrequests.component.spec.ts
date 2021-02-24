import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CallrequestsComponent } from './callrequests.component';

describe('CallrequestsComponent', () => {
  let component: CallrequestsComponent;
  let fixture: ComponentFixture<CallrequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CallrequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CallrequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

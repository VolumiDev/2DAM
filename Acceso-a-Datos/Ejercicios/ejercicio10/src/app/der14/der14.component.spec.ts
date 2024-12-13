import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Der14Component } from './der14.component';

describe('Der14Component', () => {
  let component: Der14Component;
  let fixture: ComponentFixture<Der14Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Der14Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Der14Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

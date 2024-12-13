import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer8Component } from './ejer8.component';

describe('Ejer8Component', () => {
  let component: Ejer8Component;
  let fixture: ComponentFixture<Ejer8Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer8Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer8Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

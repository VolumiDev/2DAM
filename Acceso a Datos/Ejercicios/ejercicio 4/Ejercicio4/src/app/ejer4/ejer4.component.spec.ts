import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer4Component } from './ejer4.component';

describe('Ejer4Component', () => {
  let component: Ejer4Component;
  let fixture: ComponentFixture<Ejer4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer4Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

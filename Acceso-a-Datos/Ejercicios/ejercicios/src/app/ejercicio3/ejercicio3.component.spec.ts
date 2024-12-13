import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio3Component } from './ejercicio3.component';

describe('Ejercicio3Component', () => {
  let component: Ejercicio3Component;
  let fixture: ComponentFixture<Ejercicio3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio3Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

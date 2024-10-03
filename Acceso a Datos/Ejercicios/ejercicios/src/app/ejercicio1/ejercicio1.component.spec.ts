import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio1Component } from './ejercicio1.component';

describe('Ejercicio1Component', () => {
  let component: Ejercicio1Component;
  let fixture: ComponentFixture<Ejercicio1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio1Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

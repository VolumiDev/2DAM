import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Izq14Component } from './izq14.component';

describe('Izq14Component', () => {
  let component: Izq14Component;
  let fixture: ComponentFixture<Izq14Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Izq14Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Izq14Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

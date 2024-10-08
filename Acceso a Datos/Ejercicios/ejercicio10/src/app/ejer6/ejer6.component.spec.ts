import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer6Component } from './ejer6.component';

describe('Ejer6Component', () => {
  let component: Ejer6Component;
  let fixture: ComponentFixture<Ejer6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer6Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

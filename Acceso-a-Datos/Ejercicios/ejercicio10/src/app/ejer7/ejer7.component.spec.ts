import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer7Component } from './ejer7.component';

describe('Ejer7Component', () => {
  let component: Ejer7Component;
  let fixture: ComponentFixture<Ejer7Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer7Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer7Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

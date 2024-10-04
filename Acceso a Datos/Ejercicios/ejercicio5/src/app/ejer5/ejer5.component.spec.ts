import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer5Component } from './ejer5.component';

describe('Ejer5Component', () => {
  let component: Ejer5Component;
  let fixture: ComponentFixture<Ejer5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer5Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

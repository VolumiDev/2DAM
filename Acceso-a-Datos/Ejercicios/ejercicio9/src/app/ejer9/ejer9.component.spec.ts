import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer9Component } from './ejer9.component';

describe('Ejer9Component', () => {
  let component: Ejer9Component;
  let fixture: ComponentFixture<Ejer9Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer9Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer9Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

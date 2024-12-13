import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer10Component } from './ejer10.component';

describe('Ejer10Component', () => {
  let component: Ejer10Component;
  let fixture: ComponentFixture<Ejer10Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer10Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer10Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

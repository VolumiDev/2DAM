import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer17Component } from './ejer17.component';

describe('Ejer17Component', () => {
  let component: Ejer17Component;
  let fixture: ComponentFixture<Ejer17Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer17Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer17Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

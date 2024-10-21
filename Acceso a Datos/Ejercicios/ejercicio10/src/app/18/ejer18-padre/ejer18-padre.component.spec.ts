import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer18PadreComponent } from './ejer18-padre.component';

describe('Ejer18PadreComponent', () => {
  let component: Ejer18PadreComponent;
  let fixture: ComponentFixture<Ejer18PadreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer18PadreComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer18PadreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

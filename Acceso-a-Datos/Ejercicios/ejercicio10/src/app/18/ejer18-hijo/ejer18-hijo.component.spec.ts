import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer18HijoComponent } from './ejer18-hijo.component';

describe('Ejer18HijoComponent', () => {
  let component: Ejer18HijoComponent;
  let fixture: ComponentFixture<Ejer18HijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer18HijoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer18HijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

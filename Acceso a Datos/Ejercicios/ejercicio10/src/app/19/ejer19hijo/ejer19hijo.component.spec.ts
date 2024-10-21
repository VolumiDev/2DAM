import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer19hijoComponent } from './ejer19hijo.component';

describe('Ejer19hijoComponent', () => {
  let component: Ejer19hijoComponent;
  let fixture: ComponentFixture<Ejer19hijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer19hijoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer19hijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

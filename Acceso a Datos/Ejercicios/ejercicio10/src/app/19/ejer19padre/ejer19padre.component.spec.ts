import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer19padreComponent } from './ejer19padre.component';

describe('Ejer19padreComponent', () => {
  let component: Ejer19padreComponent;
  let fixture: ComponentFixture<Ejer19padreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer19padreComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer19padreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

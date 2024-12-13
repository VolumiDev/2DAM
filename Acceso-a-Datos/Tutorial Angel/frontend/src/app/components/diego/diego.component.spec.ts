import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiegoComponent } from './diego.component';

describe('DiegoComponent', () => {
  let component: DiegoComponent;
  let fixture: ComponentFixture<DiegoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DiegoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiegoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

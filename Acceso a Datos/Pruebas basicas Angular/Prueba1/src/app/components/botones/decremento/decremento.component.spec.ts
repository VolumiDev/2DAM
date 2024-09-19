import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DecrementoComponent } from './decremento.component';

describe('DecrementoComponent', () => {
  let component: DecrementoComponent;
  let fixture: ComponentFixture<DecrementoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DecrementoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DecrementoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

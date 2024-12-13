import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncrementoComponent } from './incremento.component';

describe('IncrementoComponent', () => {
  let component: IncrementoComponent;
  let fixture: ComponentFixture<IncrementoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IncrementoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IncrementoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

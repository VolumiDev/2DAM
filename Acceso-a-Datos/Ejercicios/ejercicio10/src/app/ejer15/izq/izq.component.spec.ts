import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzqComponent } from './izq.component';

describe('IzqComponent', () => {
  let component: IzqComponent;
  let fixture: ComponentFixture<IzqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IzqComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IzqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

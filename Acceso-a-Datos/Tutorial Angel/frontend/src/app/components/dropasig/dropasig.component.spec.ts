import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DropasigComponent } from './dropasig.component';

describe('DropasigComponent', () => {
  let component: DropasigComponent;
  let fixture: ComponentFixture<DropasigComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DropasigComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DropasigComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

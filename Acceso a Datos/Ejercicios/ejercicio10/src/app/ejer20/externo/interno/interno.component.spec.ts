import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InternoComponent } from './interno.component';

describe('InternoComponent', () => {
  let component: InternoComponent;
  let fixture: ComponentFixture<InternoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InternoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InternoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejer17hijoComponent } from './ejer17hijo.component';

describe('Ejer17hijoComponent', () => {
  let component: Ejer17hijoComponent;
  let fixture: ComponentFixture<Ejer17hijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejer17hijoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejer17hijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

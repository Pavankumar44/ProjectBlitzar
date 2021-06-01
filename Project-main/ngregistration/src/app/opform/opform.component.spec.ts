import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpformComponent } from './opform.component';

describe('OpformComponent', () => {
  let component: OpformComponent;
  let fixture: ComponentFixture<OpformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamNewComponent } from './team-new.component';

describe('TeamNewComponent', () => {
  let component: TeamNewComponent;
  let fixture: ComponentFixture<TeamNewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TeamNewComponent]
    });
    fixture = TestBed.createComponent(TeamNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

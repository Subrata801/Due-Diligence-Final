import { ComponentFixture, TestBed } from '@angular/core/testing';
import { searchUnitComponent } from './search-unit.component';

describe('searchUnitComponent', () => {
  let component: searchUnitComponent;
  let fixture: ComponentFixture<searchUnitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ searchUnitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(searchUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

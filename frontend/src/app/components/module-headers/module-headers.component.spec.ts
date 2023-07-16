import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ModuleHeadersComponent } from './module-headers.component';

describe('ModuleHeadersComponent', () => {
  let component: ModuleHeadersComponent;
  let fixture: ComponentFixture<ModuleHeadersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModuleHeadersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModuleHeadersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

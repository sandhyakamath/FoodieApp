import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantFavouriteComponent } from './restaurant-favourite.component';

describe('DashboardComponent', () => {
  let component: RestaurantFavouriteComponent;
  let fixture: ComponentFixture<RestaurantFavouriteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantFavouriteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantFavouriteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

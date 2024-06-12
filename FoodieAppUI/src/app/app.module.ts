import { NgModule, APP_INITIALIZER } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RestaurantDetailComponent } from './home/restaurant-detail/restaurant-detail.component';
import { RestaurantService } from './home/service/restaurant.service';

import { AppRoutingModule } from './/app-routing.module';
import { RestaurantFavouriteComponent } from './home/restaurant-favourite/restaurant-favourite.component';
import { HttpClientModule } from '@angular/common/http';

export  function dataServiceFactory(dataService: RestaurantService)   {
  return () => dataService.loadRestaurants();
}

export  function restaurantServiceFactory(dataService: RestaurantService)   {
  return () => dataService.loadRestaurantsStatusAndComments();
}
export const myComponents = [
  AppComponent
];

@NgModule({
  declarations: [
    ...myComponents,
    HomeComponent,
    RestaurantDetailComponent,
    RestaurantFavouriteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [RestaurantService,
  {
    provide: APP_INITIALIZER,
    useFactory: dataServiceFactory,
    deps: [RestaurantService],
    multi: true
  },
  {
    provide: APP_INITIALIZER,
    useFactory: restaurantServiceFactory,
    deps: [RestaurantService],
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}

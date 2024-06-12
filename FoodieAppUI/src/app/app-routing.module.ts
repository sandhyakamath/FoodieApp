import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { HomeComponent } from './home/home.component';
import { RestaurantFavouriteComponent } from './home/restaurant-favourite/restaurant-favourite.component';
import { RestaurantDetailComponent } from './home/restaurant-detail/restaurant-detail.component';
import { RootObject } from './home/shared/restaurant.model';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'favourite', component: RestaurantFavouriteComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'detail/:id', component: RestaurantDetailComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})


export class AppRoutingModule {

}

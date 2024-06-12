import { Component, OnInit } from '@angular/core';
import { Restaurants, Restaurant } from './shared/restaurant.model';
import { RestaurantDTO } from './shared/restaurantDTO.model';
import { RestaurantService } from './service/restaurant.service';
import { RestaurantDetailComponent } from './restaurant-detail/restaurant-detail.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  restaurantLst: Restaurants[];
  geolocationPosition: any;
  isValid = false;
  clicked = true;
  constructor(
    private restaurantService: RestaurantService,
    ) { }

  ngOnInit() {
    if (window.navigator && window.navigator.geolocation) {
        window.navigator.geolocation.getCurrentPosition(
            position => {
                this.geolocationPosition = position;
                    console.log(position);
            },
            error => {
                switch (error.code) {
                    case 1:
                        console.log('Permission Denied');
                        break;
                    case 2:
                        console.log('Position Unavailable');
                        break;
                    case 3:
                        console.log('Timeout');
                        break;
                }
            }
        );
    }
    this.getRestaurants();

  }

  getRestaurants() {
    this.isValid = false;
    this.restaurantLst = this.restaurantService.getRestaurant() ;
  }

  onSearchButtonClick(location: any, cuisines: any) {
    this.restaurantLst = [];
    this.restaurantService.getRestaurantsWithLocationAndCuisines(location, cuisines).subscribe(data => { this.restaurantLst = data; }) ;
    this.isValid = true;
  }

  onFavouriteButtonClick(restaurant: Restaurant) {
    console.log(this.clicked);
    const restaurantFavLst = this.restaurantService.getFavouriteRestaurants();
    let restaurantDTO: RestaurantDTO = null;
    let enteredFlag = false;
    restaurantFavLst.forEach(item => {
        if (item.restaurantId === parseInt(restaurant.id, 10) && this.clicked) {
          item.favourite = 'Y';
          enteredFlag = true;
          restaurantDTO = item;
        } else if (item.restaurantId === parseInt(restaurant.id, 10)) {
            item.favourite = 'N';
            enteredFlag = true;
            restaurantDTO = item;
        }
      });
      if (!enteredFlag) {
        restaurantDTO = {id: '', restaurantId: restaurant.id, favourite: 'Y', comments: ''};
        this.restaurantService.restaurantFavLst.push();
      }
      this.clicked = !this.clicked;
      this.restaurantService.updateFavouriteRestaurant(restaurantDTO);
  }

}

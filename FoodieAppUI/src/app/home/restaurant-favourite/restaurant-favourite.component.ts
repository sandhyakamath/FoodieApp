import { Component, OnInit, Input, AfterViewChecked} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Restaurants } from './../shared/restaurant.model';
import { RestaurantDTO } from './../shared/restaurantDTO.model';
import { RestaurantService } from './../service/restaurant.service';
import { Restaurant } from './../shared/restaurant.model';
import { forEach } from '@angular/router/src/utils/collection';


@Component({
  selector: 'app-restaurant-favourite',
  templateUrl: './restaurant-favourite.component.html',
  styleUrls: ['./restaurant-favourite.component.css']
})
export class RestaurantFavouriteComponent implements OnInit, AfterViewChecked {
  restaurantFavLst: RestaurantDTO[];
  restaurants: Restaurants[];
  restaurantLst: Restaurants[] = new Array();

  id: any;
  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService,
    private location: Location) { }

  ngOnInit() {
    this.getRestaurants();
  }

  ngAfterViewChecked() {
  }

  getRestaurants() {
    this.restaurantFavLst = this.restaurantService.getFavouriteRestaurants();
    this.restaurants = this.restaurantService.getRestaurant();
    const favouriteLst: RestaurantDTO[] = this.restaurantFavLst.filter(item => item.favourite === 'Y');
    /* this.restaurants.forEach(item => {
      favouriteLst.forEach(data => {
        if (parseInt(item.restaurant.id, 10) === data.restaurantId) {
          this.restaurantLst.push(item);
        }
      });
    }); */
    let item: Restaurants;
    let data: RestaurantDTO;
    for (const restaurant of this.restaurants) {
      for (const favourite of favouriteLst) {
        item = restaurant;
        data = favourite;
        console.log(item.restaurant.id);
        console.log(data.restaurantId);
        if (parseInt(item.restaurant.id, 10) === data.restaurantId) {
          this.restaurantLst.push(item);
        }
      }
    }

  }

  onRemoveBtnclick(restaurant: Restaurant) {
    let restaurantDTO: RestaurantDTO = null;
    this.restaurantFavLst.forEach(item => {
        if (item.restaurantId === parseInt(restaurant.id, 10)) {
          item.favourite = 'N';
          restaurantDTO = item;
        }});
      this.restaurantService.updateFavouriteRestaurant(restaurantDTO);
  }

  goBack(): void {
    this.location.back();
  }
}

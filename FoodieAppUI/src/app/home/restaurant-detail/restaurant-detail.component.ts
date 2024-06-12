import { Component, OnInit, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Restaurants, Restaurant } from './../shared/restaurant.model';
import { RestaurantDTO } from './../shared/restaurantDTO.model';
import { RestaurantService } from './../service/restaurant.service';


@Component({
  selector: 'app-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css']
})
export class RestaurantDetailComponent implements OnInit {
  restaurantLst: Restaurants[];
  id: any;
  comment: string;
  restaurantFavLst: RestaurantDTO[];
  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService,
    private location: Location
  ) {}

  ngOnInit() {
    this.getRestaurants();
  }

  getRestaurants() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.restaurantLst = this.restaurantService.getRestaurant();
    this.getComments();
  }

  getComments() {
    this.restaurantFavLst = this.restaurantService.getFavouriteRestaurants();
    this.restaurantFavLst.forEach(item => {
      if (item.restaurantId === parseInt(this.id, 10)) {
        this.comment = item.comments;
      }});
  }

  goBack(): void {
    this.location.back();
  }

  commentBtnclicked(comment: string, restaurant: Restaurant) {
    let restaurantDTO: RestaurantDTO = null;
    let enteredFlag = false;
    this.restaurantFavLst.forEach(item => {
      if (item.restaurantId === parseInt(restaurant.id, 10)) {
        item.comments = comment;
        restaurantDTO = item;
        enteredFlag = true;
      }});
      if (!enteredFlag) {
        restaurantDTO = {id: '', restaurantId: restaurant.id, favourite: 'N', comments: comment};
        this.restaurantService.restaurantFavLst.push(restaurantDTO);
      }
    this.restaurantService.updateFavouriteRestaurant(restaurantDTO);
  }
}

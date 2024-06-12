import * as _ from 'lodash';

import { Injectable } from '@angular/core';
import { Observable } from 'RxJS/Rx';
import { of } from 'rxjs/observable/of';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { RESTAURANTS } from './../shared/mock-restaurants';
import { Restaurant } from './../shared/restaurant.model';
import { RestaurantDTO } from './../shared/restaurantDTO.model';
import { Restaurants } from './../shared/restaurant.model';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class RestaurantService {
  restaurantFavLst: RestaurantDTO[];
  restaurantLst: Restaurants[];
  data: any;
  headers: HttpHeaders;
  options: RequestOptions;
  constructor(
    private httpClient: HttpClient
  ) { }

  getRestaurant(): any {
    return this.restaurantLst;
  }

  getFavouriteRestaurants(): any {
    return this.restaurantFavLst;
  }

  getRestaurantsWithLocation(location: any): Observable<Restaurants[]> {
    return this.httpClient.get<Restaurants[]>('http://localhost:8080/search/'+location);
   //return Observable.of(RESTAURANTS);
  }

  getRestaurantsWithLocationAndCuisines(location: any, cuisines: any): Observable<Restaurants[]> {
    return this.httpClient.get<Restaurants[]>('http://localhost:8080/search/'+location+'/'+cuisines);
    //return Observable.of(RESTAURANTS);
  }

  loadRestaurants(): Promise<Restaurants[]> {
    const promise = this.httpClient.get<Restaurants[]>('http://localhost:8080/search/' + 'kochi').toPromise();
      promise.then(data => {
        this.restaurantLst = data;
        console.log(this.restaurantLst);
      }).catch(this.handleErrorPromise);
    return promise;
    /* this.restaurantLst = RESTAURANTS;
    return Promise.resolve(RESTAURANTS); */
  }

  loadRestaurantsStatusAndComments(): Promise<RestaurantDTO[]> {
    const promise = this.httpClient.get<RestaurantDTO[]>('http://localhost:8080/all').toPromise();
    promise.then(data => {
        this.restaurantFavLst = data;
        console.log(this.restaurantFavLst);
      }).catch(this.handleErrorPromise);
    return promise;
  }

  updateFavouriteRestaurant(restaurant: RestaurantDTO) {
    return this.httpClient.post<RestaurantDTO[]>('http://localhost:8080/add/status/', restaurant, httpOptions)
    .subscribe(response => console.log());
  }

  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

  private handleErrorPromise (error: Response | any) {
    console.error(error.message || error);
    return Promise.reject(error.message || error);
  }
}

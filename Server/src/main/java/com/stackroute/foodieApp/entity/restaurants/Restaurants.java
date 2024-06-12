package com.stackroute.foodieApp.entity.restaurants;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Restaurants")
public class Restaurants {
	
	private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public Restaurant getRestaurant(){
        return this.restaurant;
    }

}

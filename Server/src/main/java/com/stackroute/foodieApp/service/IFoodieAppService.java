package com.stackroute.foodieApp.service;

import java.util.List;

import com.stackroute.foodieApp.DTO.RestaurantDTO;
import com.stackroute.foodieApp.entity.restaurants.Restaurants;

public interface IFoodieAppService {
	
	List<Restaurants> searchRestaurantWithLocation(String location);
	List<Restaurants> searchRestaurantWithLocationAndCusine(String location, String[] cuisine);	
	RestaurantDTO addRestaurantComments(RestaurantDTO restaurantDTO);
	List<RestaurantDTO> getAllRestaurants();
	RestaurantDTO addRestaurantStatus(RestaurantDTO restaurantDTO); 
}

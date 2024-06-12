package com.stackroute.foodieApp.DAO;

import java.util.List;

import com.stackroute.foodieApp.domain.Restaurant;

public interface IRestaurantDAO {
	
	Restaurant addRestaurantComments(Restaurant restaurant);
	List<Restaurant> getAllRestaurants();
	Restaurant addRestaurantStatus(Restaurant restaurant); 

}

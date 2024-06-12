package com.stackroute.foodieApp.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.foodieApp.domain.Restaurant;
import com.stackroute.foodieApp.repository.RestaurantRepository;

@Component("restaurantDAO")
public class RestaurantDOAImpl implements IRestaurantDAO {
	@Autowired RestaurantRepository  restaurantRepository;

	public Restaurant addRestaurantComments(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);		
	}

	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurantList = (List<Restaurant>) restaurantRepository.findAll();		
		return restaurantList;
	}
	
	public Restaurant addRestaurantStatus(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	

}

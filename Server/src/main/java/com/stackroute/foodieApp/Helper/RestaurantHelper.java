package com.stackroute.foodieApp.Helper;

import org.springframework.stereotype.Component;

import com.stackroute.foodieApp.DTO.RestaurantDTO;
import com.stackroute.foodieApp.domain.Restaurant;

@Component("restaurantHelper")
public class RestaurantHelper {
	
	public Restaurant convertDTOToDomain(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = new Restaurant();
		if(null != restaurantDTO.getId() && "" != restaurantDTO.getId()) {
			restaurant.setId(Integer.parseInt(restaurantDTO.getId()));
		}
		restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
		restaurant.setComments(restaurantDTO.getComments());
		restaurant.setFavourite(restaurantDTO.getFavourite());
		return restaurant;
	}
	
	public RestaurantDTO convertDomainToDTO(Restaurant restaurant) {
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setId(String.valueOf(restaurant.getId()));
		restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
		restaurantDTO.setComments(restaurant.getComments());
		restaurantDTO.setFavourite(restaurant.getFavourite());
		return restaurantDTO;
	}

}

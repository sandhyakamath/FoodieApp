package com.stackroute.foodieApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.stackroute.foodieApp.DAO.IRestaurantDAO;
import com.stackroute.foodieApp.DTO.RestaurantDTO;
import com.stackroute.foodieApp.Helper.RestaurantHelper;
import com.stackroute.foodieApp.domain.Restaurant;
import com.stackroute.foodieApp.entity.cuisines.Cuisine;
import com.stackroute.foodieApp.entity.cuisines.Cuisines;
import com.stackroute.foodieApp.entity.locationSuggestions.Location_suggestions;
import com.stackroute.foodieApp.entity.restaurants.Restaurants;
import com.stackroute.foodieApp.utils.APIDespatcher;

@Service
public class FoodieAppServiceImpl implements IFoodieAppService{
	
	@Autowired Environment env;
	@Autowired IRestaurantDAO restaurantDAO;
	@Autowired RestaurantHelper restaurantHelper;
	
	public List<Restaurants> searchRestaurantWithLocation(String location) {
		String urlLocation = env.getProperty("url.location")+location;
		List<Location_suggestions> locationDetails = APIDespatcher.getLocationIdFromLocation(urlLocation);
		List<Restaurants> restaurantLst = null;
		if (locationDetails.size() != 0) {
			String urlSearch = env.getProperty("url.search");
			String entitySearch = urlSearch.replace("$entityId", String.valueOf(locationDetails.get(0).getEntity_id()));
			String citySearch = entitySearch.replace("$cityName", locationDetails.get(0).getCity_name());
			restaurantLst = APIDespatcher.searchRestaurant(citySearch);
		}
		return restaurantLst;
	}

	public List<Restaurants> searchRestaurantWithLocationAndCusine(String location, String[] cuisine) {
		String urlLocation = env.getProperty("url.location")+location;
		List<Location_suggestions> locationDetails = APIDespatcher.getLocationIdFromLocation(urlLocation);
		List<Restaurants> restaurantLst = null;
		if (locationDetails.size() != 0) {						
			String urlSearch = env.getProperty("url.searchWithCuisine");
			String entitySearch = urlSearch.replace("$entityId", String.valueOf(locationDetails.get(0).getEntity_id()));
			String citySearch = entitySearch.replace("$cityName", locationDetails.get(0).getCity_name());
			String cuisineSearch = citySearch.replace("$cuisineType",getCuisineID(locationDetails, cuisine));
			restaurantLst = APIDespatcher.searchRestaurant(cuisineSearch);
		}
		return restaurantLst;
	}

	private String getCuisineID(List<Location_suggestions> locationDetails, String[] cuisineLst) {
		String urlCuisines = env.getProperty("url.cuisine");
		String entitySearch = urlCuisines.replace("$cityId", String.valueOf(locationDetails.get(0).getCity_id()));
		List<Cuisines> cuisinesLst = APIDespatcher.searchCuisines(entitySearch);
		String cuisineId = null;
		for (Cuisines cuisines : cuisinesLst) {
			Cuisine cuisine = cuisines.getCuisine();
			for (String cuisineName : cuisineLst) {
				if (cuisine.getCuisine_name().equalsIgnoreCase(cuisineName)) {
					if (null != cuisineId) {
						cuisineId += "%2C";
						cuisineId += String.valueOf(cuisine.getCuisine_id());
					}
					else {
						cuisineId = String.valueOf(cuisine.getCuisine_id());
					}
				}
			}
		}

		return cuisineId;
	}

	public RestaurantDTO addRestaurantComments(RestaurantDTO restaurantDTO) {	
		Restaurant restaurant = restaurantDAO.addRestaurantComments(restaurantHelper.convertDTOToDomain(restaurantDTO));
		return restaurantHelper.convertDomainToDTO(restaurant);
	}

	public List<RestaurantDTO> getAllRestaurants() {
		List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();
		List<RestaurantDTO> restaurantDTOList = new ArrayList<RestaurantDTO>();
		for (Restaurant restaurant : restaurantList){
			restaurantDTOList.add(restaurantHelper.convertDomainToDTO(restaurant));
		}
		return restaurantDTOList;
	}

	public RestaurantDTO addRestaurantStatus(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = restaurantDAO.addRestaurantStatus(restaurantHelper.convertDTOToDomain(restaurantDTO));
		return restaurantHelper.convertDomainToDTO(restaurant);
	}
		
}

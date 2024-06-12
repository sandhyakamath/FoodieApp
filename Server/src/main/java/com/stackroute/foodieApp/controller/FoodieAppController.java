package com.stackroute.foodieApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.foodieApp.DTO.RestaurantDTO;
import com.stackroute.foodieApp.entity.restaurants.Restaurants;
import com.stackroute.foodieApp.service.IFoodieAppService;

@RestController
public class FoodieAppController {
	
	@Autowired IFoodieAppService foodieAppService;
	
	private static final Logger logger = LoggerFactory.getLogger(FoodieAppController.class);
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/search/{location}")
	public List<Restaurants> searchRestaurantWithLocation(@PathVariable("location")String location) {
		System.out.println("inside the controller");
		return foodieAppService.searchRestaurantWithLocation(location);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/search/{location}/{cuisine}")
	public List<Restaurants> searchRestaurantWithLocationAndCusine(
			@PathVariable("location")String location, @PathVariable("cuisine") String[] cuisine) {
		return foodieAppService.searchRestaurantWithLocationAndCusine(location, cuisine);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/add/comments", method = RequestMethod.POST)
	public RestaurantDTO addRestaurantComments(
			@ModelAttribute("restaurant") RestaurantDTO restaurant) { 
		return foodieAppService.addRestaurantComments(restaurant);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value ="/add/status", method = RequestMethod.POST)
	public RestaurantDTO addRestaurantStatus(
			@RequestBody RestaurantDTO restaurant) { 
		System.out.println("Favourite: " + restaurant.getFavourite());
		return foodieAppService.addRestaurantStatus(restaurant);
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String addRestaurantStatus2() { 
		System.out.println("Favourite: ");
		return "Hello";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/all")
	public List<RestaurantDTO> getAllRestaurants() {
		return foodieAppService.getAllRestaurants();
	}

}

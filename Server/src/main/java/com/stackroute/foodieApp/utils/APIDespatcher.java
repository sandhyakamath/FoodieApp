package com.stackroute.foodieApp.utils;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stackroute.foodieApp.entity.cuisines.Cuisines;
import com.stackroute.foodieApp.entity.locationSuggestions.Location_suggestions;
import com.stackroute.foodieApp.entity.restaurants.Restaurants;


public class APIDespatcher {
	
    private static final Logger logger = LoggerFactory.getLogger(APIDespatcher.class);
    
    public static List<Location_suggestions> getLocationIdFromLocation(String url) { 
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> entity  = getHttpEntity();
    	ResponseEntity<com.stackroute.foodieApp.entity.locationSuggestions.Root> root = restTemplate.exchange(url,
    			HttpMethod.GET,entity,com.stackroute.foodieApp.entity.locationSuggestions.Root.class);
    	return root.getBody().getLocation_suggestions();
    }
    
    public static List<Restaurants> searchRestaurant(String url) { 
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> entity  = getHttpEntity();
    	ResponseEntity<com.stackroute.foodieApp.entity.restaurants.Root> root = restTemplate.exchange(url,   			
    			HttpMethod.GET,entity,com.stackroute.foodieApp.entity.restaurants.Root.class);
    	return root.getBody().getRestaurants();
    }
    
    public static List<Cuisines> searchCuisines(String url) { 
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<String> entity  = getHttpEntity();
    	ResponseEntity<com.stackroute.foodieApp.entity.cuisines.Root> root = restTemplate.exchange(url,   			
    			HttpMethod.GET,entity,com.stackroute.foodieApp.entity.cuisines.Root.class);
    	return root.getBody().getCuisines();
    }
    
    private static HttpEntity<String> getHttpEntity() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	headers.set("user-key", "a2a040d6294d00fa0d769fa9f15e9d78");
    	HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    	return entity;
    	
    }

}

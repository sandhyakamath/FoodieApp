package com.stackroute.foodieApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "RestaurantDTO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantDTO {
	String id;
	int restaurantId;
	char favourite;
	String comments;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public char getFavourite() {
		return favourite;
	}
	public void setFavourite(char favourite) {
		this.favourite = favourite;
	}

}

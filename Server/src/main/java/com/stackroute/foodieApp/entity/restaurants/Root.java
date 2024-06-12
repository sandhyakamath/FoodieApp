package com.stackroute.foodieApp.entity.restaurants;

import java.util.List;

public class Root {
	private int results_found;

	private int results_start;

	private int results_shown;

	private List<Restaurants> restaurants;

	public void setResults_found(int results_found){
		this.results_found = results_found;
	}
	public int getResults_found(){
		return this.results_found;
	}
	public void setResults_start(int results_start){
		this.results_start = results_start;
	}
	public int getResults_start(){
		return this.results_start;
	}
	public void setResults_shown(int results_shown){
		this.results_shown = results_shown;
	}
	public int getResults_shown(){
		return this.results_shown;
	}
	public void setRestaurants(List<Restaurants> restaurants){
		this.restaurants = restaurants;
	}
	public List<Restaurants> getRestaurants(){
		return this.restaurants;
	}
}

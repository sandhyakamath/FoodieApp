package com.stackroute.foodieApp.entity.cuisines;

public class Cuisine {
	private int cuisine_id;

    private String cuisine_name;

    public void setCuisine_id(int cuisine_id){
        this.cuisine_id = cuisine_id;
    }
    public int getCuisine_id(){
        return this.cuisine_id;
    }
    public void setCuisine_name(String cuisine_name){
        this.cuisine_name = cuisine_name;
    }
    public String getCuisine_name(){
        return this.cuisine_name;
    }
}

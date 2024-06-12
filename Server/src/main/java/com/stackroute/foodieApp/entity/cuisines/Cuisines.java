package com.stackroute.foodieApp.entity.cuisines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Cuisines")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuisines {
	private Cuisine cuisine;

    public void setCuisine(Cuisine cuisine){
        this.cuisine = cuisine;
    }
    public Cuisine getCuisine(){
        return this.cuisine;
    }

}

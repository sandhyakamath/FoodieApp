package com.stackroute.foodieApp.entity.cuisines;

import java.util.List;

public class Root {
	private List<Cuisines> cuisines;

    public void setCuisines(List<Cuisines> cuisines){
        this.cuisines = cuisines;
    }
    public List<Cuisines> getCuisines(){
        return this.cuisines;
    }

}

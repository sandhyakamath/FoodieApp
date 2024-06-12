package com.stackroute.foodieApp.entity.locationSuggestions;

import java.util.List;

public class Root {
	
	private List<Location_suggestions> location_suggestions;

    private String status;

    private int has_more;

    private int has_total;

    public void setLocation_suggestions(List<Location_suggestions> location_suggestions){
        this.location_suggestions = location_suggestions;
    }
    public List<Location_suggestions> getLocation_suggestions(){
        return this.location_suggestions;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setHas_more(int has_more){
        this.has_more = has_more;
    }
    public int getHas_more(){
        return this.has_more;
    }
    public void setHas_total(int has_total){
        this.has_total = has_total;
    }
    public int getHas_total(){
        return this.has_total;
    }

}

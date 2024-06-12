package com.stackroute.foodieApp.entity.locationSuggestions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Location_suggestions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location_suggestions
{
    private String entity_type;

    private int entity_id;

    private String title;

    private double latitude;

    private double longitude;

    private int city_id;

    private String city_name;

    private int country_id;

    private String country_name;

    public void setEntity_type(String entity_type){
        this.entity_type = entity_type;
    }
    public String getEntity_type(){
        return this.entity_type;
    }
    public void setEntity_id(int entity_id){
        this.entity_id = entity_id;
    }
    public int getEntity_id(){
        return this.entity_id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setCity_id(int city_id){
        this.city_id = city_id;
    }
    public int getCity_id(){
        return this.city_id;
    }
    public void setCity_name(String city_name){
        this.city_name = city_name;
    }
    public String getCity_name(){
        return this.city_name;
    }
    public void setCountry_id(int country_id){
        this.country_id = country_id;
    }
    public int getCountry_id(){
        return this.country_id;
    }
    public void setCountry_name(String country_name){
        this.country_name = country_name;
    }
    public String getCountry_name(){
        return this.country_name;
    }
}

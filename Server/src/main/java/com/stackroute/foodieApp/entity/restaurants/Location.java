package com.stackroute.foodieApp.entity.restaurants;

public class Location {
	
	private String address;

    private String locality;

    private String city;

    private int city_id;

    private String latitude;

    private String longitude;

    private String zipcode;

    private int country_id;

    private String locality_verbose;

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setLocality(String locality){
        this.locality = locality;
    }
    public String getLocality(){
        return this.locality;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setCity_id(int city_id){
        this.city_id = city_id;
    }
    public int getCity_id(){
        return this.city_id;
    }
    public void setLatitude(String latitude){
        this.latitude = latitude;
    }
    public String getLatitude(){
        return this.latitude;
    }
    public void setLongitude(String longitude){
        this.longitude = longitude;
    }
    public String getLongitude(){
        return this.longitude;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
    public String getZipcode(){
        return this.zipcode;
    }
    public void setCountry_id(int country_id){
        this.country_id = country_id;
    }
    public int getCountry_id(){
        return this.country_id;
    }
    public void setLocality_verbose(String locality_verbose){
        this.locality_verbose = locality_verbose;
    }
    public String getLocality_verbose(){
        return this.locality_verbose;
    }

}

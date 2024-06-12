package com.stackroute.foodieApp.entity.restaurants;

import java.util.List;

public class Restaurant {
	private R R;

    private String apikey;

    private String id;

    private String name;

    private String url;

    private Location location;

    private int switch_to_order_menu;

    private String cuisines;

    private int average_cost_for_two;

    private int price_range;

    private String currency;

    private List<String> offers;

    private String thumb;

    private User_rating user_rating;

    private String photos_url;

    private String menu_url;

    private String featured_image;

    private int has_online_delivery;

    private int is_delivering_now;

    private String deeplink;

    private int has_table_booking;

    private String events_url;

    private List<String> establishment_types;

    public void setR(R R){
        this.R = R;
    }
    public R getR(){
        return this.R;
    }
    public void setApikey(String apikey){
        this.apikey = apikey;
    }
    public String getApikey(){
        return this.apikey;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setSwitch_to_order_menu(int switch_to_order_menu){
        this.switch_to_order_menu = switch_to_order_menu;
    }
    public int getSwitch_to_order_menu(){
        return this.switch_to_order_menu;
    }
    public void setCuisines(String cuisines){
        this.cuisines = cuisines;
    }
    public String getCuisines(){
        return this.cuisines;
    }
    public void setAverage_cost_for_two(int average_cost_for_two){
        this.average_cost_for_two = average_cost_for_two;
    }
    public int getAverage_cost_for_two(){
        return this.average_cost_for_two;
    }
    public void setPrice_range(int price_range){
        this.price_range = price_range;
    }
    public int getPrice_range(){
        return this.price_range;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public void setOffers(List<String> offers){
        this.offers = offers;
    }
    public List<String> getOffers(){
        return this.offers;
    }
    public void setThumb(String thumb){
        this.thumb = thumb;
    }
    public String getThumb(){
        return this.thumb;
    }
    public void setUser_rating(User_rating user_rating){
        this.user_rating = user_rating;
    }
    public User_rating getUser_rating(){
        return this.user_rating;
    }
    public void setPhotos_url(String photos_url){
        this.photos_url = photos_url;
    }
    public String getPhotos_url(){
        return this.photos_url;
    }
    public void setMenu_url(String menu_url){
        this.menu_url = menu_url;
    }
    public String getMenu_url(){
        return this.menu_url;
    }
    public void setFeatured_image(String featured_image){
        this.featured_image = featured_image;
    }
    public String getFeatured_image(){
        return this.featured_image;
    }
    public void setHas_online_delivery(int has_online_delivery){
        this.has_online_delivery = has_online_delivery;
    }
    public int getHas_online_delivery(){
        return this.has_online_delivery;
    }
    public void setIs_delivering_now(int is_delivering_now){
        this.is_delivering_now = is_delivering_now;
    }
    public int getIs_delivering_now(){
        return this.is_delivering_now;
    }
    public void setDeeplink(String deeplink){
        this.deeplink = deeplink;
    }
    public String getDeeplink(){
        return this.deeplink;
    }
    public void setHas_table_booking(int has_table_booking){
        this.has_table_booking = has_table_booking;
    }
    public int getHas_table_booking(){
        return this.has_table_booking;
    }
    public void setEvents_url(String events_url){
        this.events_url = events_url;
    }
    public String getEvents_url(){
        return this.events_url;
    }
    public void setEstablishment_types(List<String> establishment_types){
        this.establishment_types = establishment_types;
    }
    public List<String> getEstablishment_types(){
        return this.establishment_types;
    }

}

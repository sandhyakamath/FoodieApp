package com.stackroute.foodieApp.entity.restaurants;

public class User_rating {
	
	private String aggregate_rating;

    private String rating_text;

    private String rating_color;

    private String votes;

    public void setAggregate_rating(String aggregate_rating){
        this.aggregate_rating = aggregate_rating;
    }
    public String getAggregate_rating(){
        return this.aggregate_rating;
    }
    public void setRating_text(String rating_text){
        this.rating_text = rating_text;
    }
    public String getRating_text(){
        return this.rating_text;
    }
    public void setRating_color(String rating_color){
        this.rating_color = rating_color;
    }
    public String getRating_color(){
        return this.rating_color;
    }
    public void setVotes(String votes){
        this.votes = votes;
    }
    public String getVotes(){
        return this.votes;
    }

}

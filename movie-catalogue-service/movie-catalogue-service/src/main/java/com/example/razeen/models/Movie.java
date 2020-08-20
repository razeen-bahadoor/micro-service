package com.example.razeen.models;

public class Movie {
    private String movieId;
    private String name;
    private int rating;

    public Movie(){

    }
    public Movie(String movieId, String name, int rating) {
        this.movieId = movieId;
        this.name = name;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

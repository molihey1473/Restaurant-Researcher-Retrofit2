package com.example.roy1473.restaurantexample.Models;

/**
 * Created by Roy1473 on 2017/03/19.
 */

public class GourmetData {
    public Results results;
    public Photo photo;

    public GourmetData(Results results){
        this.results = results;
    }

    public GourmetData(Photo photo){
        this.photo = photo;
    }

}

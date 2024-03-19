package com.project.uber.driver;

import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;
import com.project.uber.util.Util;

public class Driver {
    private static int id_seq = 0;
    private int id;
    private String name;
    private boolean available;
    private RATING rating;
    private Location location;


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void updateAvailable(boolean available) {
        this.available = available;
    }

    public RATING getRating() {
        return rating;
    }

    public void setRating(RATING rating) {
        this.rating = rating;
    }

    public Driver(String name, RATING rating) {
        this.id = ++id_seq;
        this.name = name;
        this.available = true;
        this.rating = rating;
    }

    public Driver(String name, RATING rating, Location location) {
        this.id = ++id_seq;
        this.name = name;
        this.available = true;
        this.rating = rating;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", rating=" + Util.ratingToString(rating) +
                '}';
    }
}

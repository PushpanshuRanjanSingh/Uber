package com.project.uber.rider;

import com.project.uber.dto.RATING;

public class Rider {
    private static int id_seq = 0;
    private int id;
    private String name;
    private RATING rating;

    public void setRating(RATING rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }

    public Rider(String name, RATING rating) {
        this.id = ++id_seq;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}

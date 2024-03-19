package com.project.uber.util;

import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;

public class Util {
    public static String ratingToString(RATING rating){
        return switch (rating){
            case UNASSIGNED -> null;
            case ONE_STAR -> "One Star";
            case TWO_STARS -> "Two Star";
            case THREE_STARS -> "Three Star";
            case FOUR_STARS -> "Four Star";
            case FIVE_STARS -> "Five Star";
        };
    }
    public static boolean isHighRating(RATING rating) {
        return rating == RATING.FOUR_STARS || rating == RATING.FIVE_STARS;
    }

    public static double getDistanceFromLatLonInKm(Location src,  Location dest) {
        double lat1 = src.getLatitude();
        double lon1 = src.getLongitude();
        double lat2 = dest.getLatitude();
        double lon2 = dest.getLongitude();
        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2 - lat1); // deg2rad below
        double dLon = deg2rad(lon2 - lon1);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }

    private static double deg2rad(double deg) {
        return deg * (Math.PI / 180);
    }
}

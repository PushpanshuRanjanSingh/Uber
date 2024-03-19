package com.project.uber.strategy.rider;

import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;
import com.project.uber.strategy.rider.PricingStrategy;
import com.project.uber.trip.TripMetaData;
import com.project.uber.util.Util;

public class RatingBasedPricingStrategy implements PricingStrategy {
    private double pricePerKM = 9;
    private static final int BASE_FARE = 80;

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        Location src = tripMetaData.getSrcLocation();
        Location dest = tripMetaData.getDestLocation();
        double price = Util.getDistanceFromLatLonInKm(src, dest) * pricePerKM + BASE_FARE;
        return applyDiscountOnHighRatingRider(tripMetaData.getRiderRating(), price);
    }

    private double applyDiscountOnHighRatingRider(RATING rating, double price) {
        if (Util.isHighRating(rating)) {
            return price - (0.1 * price);
        }
        return price;
    }
}

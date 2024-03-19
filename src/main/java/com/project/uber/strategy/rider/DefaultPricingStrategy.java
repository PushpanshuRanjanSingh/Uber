package com.project.uber.strategy.rider;

import com.project.uber.dto.Location;
import com.project.uber.trip.TripMetaData;
import com.project.uber.util.Util;

public class DefaultPricingStrategy implements PricingStrategy {
    private double pricePerKM = 9;
    private static final int BASE_FARE = 80;

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        Location src = tripMetaData.getSrcLocation();
        Location dest = tripMetaData.getDestLocation();
        return Util.getDistanceFromLatLonInKm(src, dest) * pricePerKM + BASE_FARE;
    }
}

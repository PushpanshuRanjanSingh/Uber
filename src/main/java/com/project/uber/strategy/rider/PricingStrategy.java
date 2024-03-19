package com.project.uber.strategy.rider;

import com.project.uber.trip.TripMetaData;

public interface PricingStrategy {
    public double calculatePrice(TripMetaData tripMetaData);
}

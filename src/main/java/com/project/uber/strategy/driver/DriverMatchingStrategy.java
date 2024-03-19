package com.project.uber.strategy.driver;

import com.project.uber.driver.Driver;
import com.project.uber.trip.TripMetaData;

public interface DriverMatchingStrategy {
    public Driver matchDriver(TripMetaData tripMetaData);
}

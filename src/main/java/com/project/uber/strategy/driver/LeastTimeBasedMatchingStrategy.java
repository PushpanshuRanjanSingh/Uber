package com.project.uber.strategy.driver;

import com.project.uber.driver.Driver;
import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;
import com.project.uber.trip.TripMetaData;
import com.project.uber.util.Util;

import java.util.*;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

    List<Driver> fakeDrivers = List.of(
            new Driver("John Doe", RATING.FIVE_STARS, new Location(28.4325168, 77.02405)),
            new Driver("Alice Smith", RATING.FOUR_STARS, new Location(29.0522, 77.2437)),
            new Driver("Bob Johnson", RATING.THREE_STARS, new Location(24.5074, 79.1278)),
            new Driver("Emma Brown", RATING.FIVE_STARS, new Location(48.8566, 72.3522)),
            new Driver("Michael Wilson", RATING.FOUR_STARS, new Location(35.6895, 80.6917))
    );


    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        Location src = tripMetaData.getSrcLocation();
        double minDistance = Double.MAX_VALUE;
        Driver nearestDriver = null;

        for (Driver driver : fakeDrivers) {
            double distance = Util.getDistanceFromLatLonInKm(src, driver.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }
        tripMetaData.setDriverRating(nearestDriver.getRating());
        return nearestDriver;

    }


}

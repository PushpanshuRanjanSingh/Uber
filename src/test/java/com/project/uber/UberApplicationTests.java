package com.project.uber;

import com.project.uber.driver.Driver;
import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;
import com.project.uber.strategy.driver.LeastTimeBasedMatchingStrategy;
import com.project.uber.strategy.rider.DefaultPricingStrategy;
import com.project.uber.strategy.rider.RatingBasedPricingStrategy;
import com.project.uber.trip.TripMetaData;
import com.project.uber.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UberApplicationTests {
    Location src = new Location(28.4325168,77.02405);
    Location dest = new Location(28.4370825,77.0670057);


    @Test
    void distanceBWTwoPointTest() {
        double distance = Util.getDistanceFromLatLonInKm(src, dest);
        double expectedDistance = 4.230792669211982;
        assertEquals(expectedDistance, distance, 0.0001);
    }


    @Test
    void defaultPricingStrategyTest() {
        TripMetaData tripMetaDataLowRating = new TripMetaData(RATING.TWO_STARS, src, dest);
        double price = new DefaultPricingStrategy().calculatePrice(tripMetaDataLowRating);
        assertEquals(118.077134022907838, price, 0.00001);
    }

    @Test
    void ratingBasedPricingStrategyLowRatingTest() {
        TripMetaData tripMetaDataLowRating = new TripMetaData(RATING.TWO_STARS, src, dest);
        double price = new RatingBasedPricingStrategy().calculatePrice(tripMetaDataLowRating);
        assertEquals(118.077134022907838, price);
    }

    @Test
    void ratingBasedPricingStrategyHighRatingTest() {
        TripMetaData tripMetaDataHighRating = new TripMetaData(RATING.FIVE_STARS, src, dest);
        double price = new RatingBasedPricingStrategy().calculatePrice(tripMetaDataHighRating);
        assertEquals(106.26942062061705, price);
    }

    @Test
    void leastTimeBasedMatchingStrategy1() {
        TripMetaData tripMetaDataLowRating = new TripMetaData(RATING.TWO_STARS, src, dest);
        Driver driver = new LeastTimeBasedMatchingStrategy().matchDriver(tripMetaDataLowRating);
        assertEquals("John Doe", driver.getName());
    }

    @Test
    void leastTimeBasedMatchingStrategy2() {
        Location location = new Location(48.8555, 72.3522);
        TripMetaData tripMetaDataLowRating = new TripMetaData(RATING.TWO_STARS, location, dest);
        Driver driver = new LeastTimeBasedMatchingStrategy().matchDriver(tripMetaDataLowRating);
        assertEquals("Emma Brown", driver.getName());
    }


}

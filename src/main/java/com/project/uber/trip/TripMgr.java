package com.project.uber.trip;

import com.project.uber.driver.Driver;
import com.project.uber.driver.DriverMgr;
import com.project.uber.dto.Location;
import com.project.uber.rider.Rider;
import com.project.uber.rider.RiderMgr;
import com.project.uber.strategy.StrategyMgr;
import com.project.uber.strategy.driver.DriverMatchingStrategy;
import com.project.uber.strategy.rider.PricingStrategy;

import java.util.HashMap;

public class TripMgr {
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    private HashMap<Integer, TripMetaData> tripMetaDataInfo;
    private HashMap<Integer, Trip> tripsInfo;
    private static TripMgr tripMgrInstance;
    private static int trip_id=0;


    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
        tripMetaDataInfo = new HashMap<>();
        tripsInfo = new HashMap<>();
    }

    public static TripMgr getTripMgr() {
                if (tripMgrInstance == null)
                    tripMgrInstance = new TripMgr();
                return tripMgrInstance;
    }

    public void createTrip(Rider rider, Location src, Location dest) {
        TripMetaData metaData = new TripMetaData(rider.getRating(),src,dest);
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(metaData);

        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        double tripPrice = pricingStrategy.calculatePrice(metaData);

        Trip trip = new Trip(driver, rider, src, dest, tripPrice, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripMetaDataInfo.put(tripId, metaData);


    }
    public HashMap<Integer, Trip> getTripsInfo() {
        return tripsInfo;
    }
}

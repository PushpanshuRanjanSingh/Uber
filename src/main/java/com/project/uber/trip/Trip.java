package com.project.uber.trip;

import com.project.uber.driver.Driver;
import com.project.uber.dto.Location;
import com.project.uber.dto.TripStatus;
import com.project.uber.rider.Rider;
import com.project.uber.strategy.driver.DriverMatchingStrategy;
import com.project.uber.strategy.rider.PricingStrategy;

public class Trip {
    private static int trip_id = 0;
    private Driver driver;
    private Rider rider;
    private Location srcLoc;
    private Location destLoc;
    private TripStatus status;

    public int getTripId() {
        return tripId;
    }

    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public String getTripDetail() {
        return "Trip{" +
                "driver=" + driver +
                ", rider=" + rider +
                ", srcLoc=" + srcLoc +
                ", destLoc=" + destLoc +
                ", status=" + status +
                ", tripId=" + tripId +
                ", price=" + price +
                ", pricingStrategy=" + pricingStrategy.getClass().getSimpleName() +
                ", driverMatchingStrategy=" + driverMatchingStrategy.getClass().getSimpleName() +
                '}';
    }

    public Trip(Driver driver, Rider rider, Location srcLoc, Location destLoc, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.driver = driver;
        this.rider = rider;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.status = TripStatus.DRIVER_ON_THE_WAY;
        this.tripId = ++trip_id;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
    }
}

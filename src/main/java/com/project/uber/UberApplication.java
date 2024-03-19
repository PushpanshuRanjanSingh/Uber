package com.project.uber;

import com.project.uber.driver.Driver;
import com.project.uber.driver.DriverMgr;
import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;
import com.project.uber.rider.Rider;
import com.project.uber.rider.RiderMgr;
import com.project.uber.trip.Trip;
import com.project.uber.trip.TripMgr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class UberApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberApplication.class, args);




        // Creating Riders and Drivers
        Rider keertiRider = new Rider("Keerti", RATING.FIVE_STARS);
        Rider gauravRider = new Rider("Gaurav", RATING.TWO_STARS);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("keerti", keertiRider);
        riderMgr.addRider("gaurav", gauravRider);

        Driver yogitaDriver = new Driver("Yogita", RATING.THREE_STARS);
        Driver riddhiDriver = new Driver("Riddhi", RATING.FOUR_STARS);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("yogita", yogitaDriver);
        driverMgr.addDriver("riddhi", riddhiDriver);

        // Creating Trip Manager
        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("\nCreating Trip for Keerti from location (28.4325168,77.02405) to (28.4370825,77.0670057)\n");
        tripMgr.createTrip(keertiRider, new Location(28.4325168,77.02405),  new Location(28.4370825,77.0670057));

        System.out.println("\nCreating Trip for Gaurav from location (48.8555, 72.3522) to (28.4370825,77.0670057)\n");
        tripMgr.createTrip(gauravRider, new Location(48.8555, 72.3522),  new Location(28.4370825,77.0670057));

        // Displaying all the trips created
        Map<Integer, Trip> tripsMap = tripMgr.getTripsInfo();
        for (Trip trip : tripsMap.values()) {
            System.out.println(trip.getTripDetail());
        }
    }

}

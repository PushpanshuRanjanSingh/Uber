package com.project.uber.trip;

import com.project.uber.dto.Location;
import com.project.uber.dto.RATING;

public class TripMetaData {
    private RATING riderRating;
    private RATING driverRating;
    private Location srcLocation;
    private Location destLocation;

    public Location getSrcLocation() {
        return srcLocation;
    }

    public Location getDestLocation() {
        return destLocation;
    }

    public RATING getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(RATING riderRating) {
        this.riderRating = riderRating;
    }

    public RATING getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(RATING driverRating) {
        this.driverRating = driverRating;
    }

    public TripMetaData(RATING riderRating, Location srcLocation, Location destLocation) {
        this.riderRating = riderRating;
        this.srcLocation = srcLocation;
        this.destLocation = destLocation;
        this.driverRating = RATING.UNASSIGNED;
    }

}

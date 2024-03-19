package com.project.uber.strategy;

import com.project.uber.strategy.driver.DriverMatchingStrategy;
import com.project.uber.strategy.driver.LeastTimeBasedMatchingStrategy;
import com.project.uber.strategy.rider.DefaultPricingStrategy;
import com.project.uber.strategy.rider.PricingStrategy;
import com.project.uber.strategy.rider.RatingBasedPricingStrategy;
import com.project.uber.trip.TripMetaData;
import com.project.uber.util.Util;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance;

    private StrategyMgr() {
    }

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null)
            strategyMgrInstance = new StrategyMgr();
        return strategyMgrInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        return Util.isHighRating(metaData.getRiderRating()) ? new RatingBasedPricingStrategy() : new DefaultPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        return new LeastTimeBasedMatchingStrategy();
    }
}

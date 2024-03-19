package com.project.uber.rider;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class RiderMgr {
    private static final RiderMgr riderMgrInstance = createInstance();
    private Map<String, Rider> ridersMap = new HashMap<>();

    private RiderMgr() {
    }

    public static RiderMgr getRiderMgr() {
        return riderMgrInstance;
    }

    public void addRider(String riderName, Rider rider) {
        ridersMap.put(riderName, rider);
    }

    public Rider getRider(String riderName) {
        return ridersMap.get(riderName);
    }

    public Map<String, Rider> getRiderMap() {
        return ridersMap;
    }

    private static RiderMgr createInstance() {
        try {
            Constructor<RiderMgr> constructor = RiderMgr.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
}

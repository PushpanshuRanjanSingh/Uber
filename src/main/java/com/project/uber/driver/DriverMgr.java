package com.project.uber.driver;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DriverMgr {
    private static final DriverMgr driverMgrInstance = createInstance();
    private Map<String, Driver> driversMap = new HashMap<>();

    private DriverMgr() {
    }

    public static DriverMgr getDriverMgr() {
        return driverMgrInstance;
    }

    public void addDriver(String pDriverName, Driver pDriver) {
        driversMap.put(pDriverName, pDriver);
    }

    public Driver getDriver(String pDriverName) {
        return driversMap.get(pDriverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }

    private static DriverMgr createInstance() {
        try {
            Constructor<DriverMgr> constructor = DriverMgr.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
}

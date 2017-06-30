package com.harsh.helper;

/**
 * Created by Harsh on 6/29/2017.
 */
public class Constant {

    public enum ALERT_PRIORITY {
        HIGH,
        MEDIUM,
        LOW
    }

    public enum ALERT_TYPE {
        COOLANT,
        ENGINE_RPM,
        FUEL,
        TIRE_PRESSURE,
        ENGINE_LIGHT
    }

    public static int MIN_FUEL_REQUIRED_PERCENTAGE = 10;
    public static int MIN_TIRE_PRESSURE_ALLOWED = 32;
    public static int MAX_TIRE_PRESSURE_ALLOWED = 36;

    public static String ALERT_MESSAGE_FOR_REDLINE_RPM = "Engine RPM is more than Red line RPM";
    public static String ALERT_MESSAGE_FOR_MIN_FUEL_LEVEL = "Minimum fuel level reached";
    public static String ALERT_MESSAGE_FOR_TIRE_PRESSURE = "Check tire pressure";
    public static String ALERT_MESSAGE_FOR_LOW_ENGINE_COOLANT = "Engine coolant low";
    public static String ALERT_MESSAGE_FOR_LOW_ENGINE_LIGHT = "Please check Engine";

}

package com.fienc.taxipassenger.models;

public class TravelHistory {

    private String date;
    private double cost;
    private Location firstLocation;
    private Location secondLocation;
    private Taxi taxi;
    private Driver driver;

    public TravelHistory(String date, double cost, Location firstLocation, Location secondLocation,
                         Taxi taxi, Driver driver) {
        this.date = date;
        this.cost = cost;
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;
        this.taxi = taxi;
        this.driver = driver;
    }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public Driver getDriver() {
        return driver;
    }
}

package com.fienc.taxipassenger.models;

public class RouteFare {

    private String routeID;
    private Location firstLocation;
    private Location secondLocation;
    private double cost;

    public RouteFare(String routeID, Location firstLocation, Location secondLocation, double cost) {
        this.routeID = routeID;
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;
        this.cost = cost;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public void setFirstLocation(Location firstLocation) {
        this.firstLocation = firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public void setSecondLocation(Location secondLocation) {
        this.secondLocation = secondLocation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

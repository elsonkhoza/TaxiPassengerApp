package com.fienc.taxipassenger.models;

public class TaxiRank {

    private String taxiTankID;
    private Location location;

    public TaxiRank(String taxiTankID, Location location) {
        this.taxiTankID = taxiTankID;
        this.location = location;
    }

    public String getTaxiTankID() {
        return taxiTankID;
    }

    public void setTaxiTankID(String taxiTankID) {
        this.taxiTankID = taxiTankID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

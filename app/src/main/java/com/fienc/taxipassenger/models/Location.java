package com.fienc.taxipassenger.models;

public class Location {

    private String name;
    private String googleMapID;

    public Location(String name, String googleMapID) {
        this.name = name;
        this.googleMapID = googleMapID;
    }

    public String getName() {
        return name;
    }

    public String getGoogleMapID() {
        return googleMapID;
    }
}

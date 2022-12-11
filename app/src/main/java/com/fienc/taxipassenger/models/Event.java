package com.fienc.taxipassenger.models;

public class Event {

    private String venue;
    private Location location;
    private String phone;
    private String website;
    private String date;
    private  String time;
    private  String name;

    public Event(String venue, Location location, String phone, String website, String date, String time, String name) {
        this.venue = venue;
        this.location = location;
        this.phone = phone;
        this.website = website;
        this.date = date;
        this.time = time;
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public Location getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}

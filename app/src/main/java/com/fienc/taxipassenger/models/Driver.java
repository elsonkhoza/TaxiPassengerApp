package com.fienc.taxipassenger.models;

public class Driver {

    private String name;
    private String surname;
    private String occupation;
    private String phoneNumber;
    private Location taxiRank;

    public Driver() {
    }
    public Driver(String name, String surname, String occupation, String phoneNumber, Location taxiRank) {
        this.name = name;
        this.surname = surname;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.taxiRank = taxiRank;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Location getTaxiRank() {
        return taxiRank;
    }
}

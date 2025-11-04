package com.spareroom;

import java.util.ArrayList;
import java.util.List;

public abstract class Accommodation {
    protected String id;
    protected String description;
    protected String location;
    protected double pricePerNight;
    protected List<Facility> facilities;
    protected boolean isBooked = false;

    public Accommodation(String id, String description, String location, double pricePerNight) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.facilities = new ArrayList<>();
    }

    public void addFacility(Facility facility) {
        facilities.add(facility);
    }

    public boolean isAvailable() {
        return !isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }

    public abstract void print();
}


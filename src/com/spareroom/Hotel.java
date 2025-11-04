package com.spareroom;

public class Hotel extends Accommodation {
    protected int bedCount;

    public Hotel(String id, String description, String location, double pricePerNight, int bedCount) {
        super(id, description, location, pricePerNight);
        this.bedCount = bedCount;
    }

    @Override
    public void print() {
        System.out.println("Hotel " + description + " (" + location + ") - $" + pricePerNight +
                "/night, Beds: " + bedCount + ", Facilities: " + facilities);
    }
}


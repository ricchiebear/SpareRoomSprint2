package com.spareroom;

public class Apartment extends Accommodation {
    private int bedCount;

    public Apartment(String id, String description, String location, double pricePerNight) {
        super(id, description, location, pricePerNight);
        this.bedCount = bedCount;
    }

    @Override
    public void print() {

    }
}

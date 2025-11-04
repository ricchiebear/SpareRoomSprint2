package com.spareroom;

public class Villa extends Accommodation {
    protected boolean hasPool;

    public Villa(String id, String description, String location, double pricePerNight, boolean hasPool) {
        super(id, description, location, pricePerNight);
        this.hasPool = hasPool;
    }

    @Override
    public void print() {
        System.out.println("Villa " + description + " (" + location + ") - $" + pricePerNight +
                "/night, Has pool: " + hasPool + ", Facilities: " + facilities);
    }
}

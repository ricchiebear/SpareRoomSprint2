package com.spareroom;

public class Room extends Accommodation {
    private final int bedCount;

    public Room(String id, String description, String location, double pricePerNight, int bedCount) {
        super(id, description, location, pricePerNight);
        this.bedCount = bedCount;
    }

    @Override
    public void print() {
        System.out.print("Room");
        print();
    }
}

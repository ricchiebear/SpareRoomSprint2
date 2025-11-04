package com.spareroom;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected int userID;
    protected String name;
    protected String email;
    protected List<Accommodation> bookings;

    public User(int userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBooking(Accommodation accommodation) {
        bookings.add(accommodation);
    }

    public void printBookings() {
        System.out.println("Bookings for " + name + ":");
        for (Accommodation a : bookings) {
            a.print();
        }
    }

    @Override
    public String toString() {
        return "User: " + name + " (" + email + ")";
    }
}


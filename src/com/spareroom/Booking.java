package com.spareroom;

public class Booking {
    protected int bookingID;
    protected User user;
    protected Accommodation accommodation;
    protected boolean isActive;

    public Booking(int bookingID, User user, Accommodation accommodation) {
        this.bookingID = bookingID;
        this.user = user;
        this.accommodation = accommodation;
        this.isActive = true;
    }

    public void cancelBooking() {
        isActive = false;
        accommodation.setBooked(false);
    }

    public void printBooking() {
        System.out.println("Booking ID: " + bookingID +
                " | User: " + user.getName() +
                " | " + accommodation.description +
                " | Active: " + isActive);
    }
}


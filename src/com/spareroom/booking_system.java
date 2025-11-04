package com.spareroom;

import java.util.ArrayList;
import java.util.List;

public class booking_system {
    protected List<User> users;
    protected List<Accommodation> accommodations;
    protected List<Booking> bookings;

    public booking_system() {
        users = new ArrayList<>();
        accommodations = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public void makeBooking(User user, Accommodation accommodation) {
        if (accommodation.isAvailable()) {
            Booking booking = new Booking(bookings.size() + 1, user, accommodation);
            bookings.add(booking);
            accommodation.setBooked(true);
            user.addBooking(accommodation);
            System.out.println("✅ " + user.getName() + " successfully booked " + accommodation.description);
        } else {
            System.out.println(" Sorry, " + accommodation.description + " is already booked.");
        }
    }

    public void listAllBookings() {
        System.out.println("\n=== All Bookings ===");
        for (Booking b : bookings) {
            b.printBooking();
        }
    }

    public void listAllUsers() {
        System.out.println("\n=== All Users ===");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void listAllAccommodations() {
        System.out.println("\n=== All Accommodations ===");
        for (Accommodation a : accommodations) {
            a.print();
        }
    }
}

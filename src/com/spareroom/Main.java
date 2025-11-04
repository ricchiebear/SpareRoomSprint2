package com.spareroom;

public class Main {
    static void main(String[] args) {
        booking_system system = new booking_system();

        Facility wifi = new Facility("WiFi");
        Facility kitchen = new Facility("Kitchen");
        Facility washer = new Facility("Washing Machine");

        User u1 = new User(1, "Richard Akole", "akole.richard@gmail.com");
        User u2 = new User(2, "Luke pring", "sarah@gmail.com");

        Hotel h1 = new Hotel("H001", "Budget Hotel", "Roehampton", 45.00, 2);
        h1.addFacility(wifi);
        Villa v1 = new Villa("V001", "Sea View Villa", "Brighton", 350.00, true);
        v1.addFacility(wifi);
        v1.addFacility(kitchen);
        v1.addFacility(washer);
        Hotel h2 = new Hotel("H002", "City Center Hotel", "Hackney", 150.00, 3);
        h2.addFacility(wifi);
        system.addUser(u1);
        system.addUser(u2);
        system.addAccommodation(h1);
        system.addAccommodation(v1);
        system.addAccommodation(h2);

        system.makeBooking(u1, v1);
        system.makeBooking(u2, v1);

        system.listAllUsers();
        system.listAllAccommodations();
        system.listAllBookings();

        u1.printBookings();
    }
}



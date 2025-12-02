SpareB&B – Sprint 2 (UoR SD3)

Java application modelling a simple room booking platform.

Sprint 2 – Booking System & OOP Design

# Overview

Sprint 2 introduces an actual booking workflow on top of the Sprint 1 domain model.

The core logic lives in:

•	Booking.java – models a single booking between a Guest and an Accommodation.

•	BookingSystem.java – central controller that manages hosts, guests, accommodations, and bookings.

•	Main.java (or App.java) – seeds some example data, calls into BookingSystem, and prints or displays the results for the demo.

# Sprint 1 focused on the core entities:

•	Host – owns one or more accommodations.

•	Guest – can create bookings.

•	Accommodation – a room/flat with properties like title, city, and nightly price.

# Sprint 2 builds on that by:

•	Allowing guests to create bookings for an accommodation.

•	Listing bookings per guest and per accommodation.

•	Preventing double-booking using simple date-overlap checks.


# AI Usage Transparency

I used AI selectively during this sprint to:

•	clarify some OOP concepts (encapsulation, composition, etc.),

•	clean up wording for this documentation,

•	and help with a few naming / refactoring ideas.

All class design, booking logic, and problem-solving decisions were implemented and debugged by me.

Domain Model (OOP)

The system is modelled with plain Java classes:

•	Host Holds host details and (optionally) references to their accommodations.

•	Guest represents a user who can book accommodations.
•	Accommodation Fields typically include:
•	id
•	title
•	city
•	nightlyPrice
•	a reference to its Host
•	Booking Connects one Guest to one Accommodation over a date range:
•	id
•	guest
•	accommodation
•	startDate
•	endDate
•	totalPrice (optional, can be derived from date range × nightlyPrice)
•	BookingSystem Owns the collections and provides the main API:
•	List<Host> hosts
•	List<Guest> guests
•	List<Accommodation> accommodations
•	List<Booking> bookings


# This design uses:

•	Encapsulation – collections are private; access goes through methods.

•	Composition – a Booking is composed of a Guest + Accommodation; BookingSystem is composed of lists of objects.

•	(Optional in your code) Inheritance – could be added later with a shared User base class for Host and Guest.

# Core Booking API (BookingSystem)


Method names / signatures – adjust to match your code.
Method	Description
addHost(Host host)	Registers a new host in the system.
addGuest(Guest guest)	Registers a new guest.
addAccommodation(Accommodation a)	Adds a new accommodation and links it to a host.
createBooking(int guestId, int accommodationId, LocalDate start, LocalDate end)	Validates input, checks availability, creates and stores a new Booking, and returns it.
getBookingsForGuest(int guestId)	Returns all bookings belonging to a particular guest.
getBookingsForAccommodation(int accommodationId)	Returns all bookings for a specific accommodation.
isAccommodationAvailable(int accommodationId, LocalDate start, LocalDate end)	Checks existing bookings and returns true only if there is no overlapping booking.<img width="468" height="349" alt="image" src="https://github.com/user-attachments/assets/2e8de808-1bab-4a64-ac13-73258408234f" />


 # Booking Rules
 
For an accommodation with ID accommodationId, when creating a booking for [startDate, endDate]:
1.	Guest and accommodation must exist If either ID is unknown, the method logs/throws an error and does not create a booking.

2.	Date range must be valid startDate must be before endDate.

3.	No overlapping bookings For every existing booking b of the same accommodation:
•	If the new range overlaps b’s range in any way, the booking is rejected.

4.	In pseudo-logic:    if newStart <= existingEnd && newEnd >= existingStart    → conflict → reject

5.	  If all checks pass, the new Booking is created and stored in the bookings list.

# Usage Flow (Demo Scenario)

1.	Seed data
In Main.java:
•	Create some Host and Guest objects.

•	Create a few Accommodation objects and add them to BookingSystem.

•	Optionally, pre-create one example booking for demonstration.

2. Create a booking

BookingSystem system = new BookingSystem();

// Example setup (simplified)
system.addGuest(new Guest(1, "richard"));
system.addHost(new Host(1, luke"));
system.addAccommodation(new Accommodation(1, "Cozy Room in London", "London", 75.0, 1));

// Create booking
Booking booking = system.createBooking(
        1,                  // guestId
        1,                  // accommodationId
        LocalDate.of(2025, 12, 10),
        LocalDate.of(2025, 12, 15)
);

System.out.println("Created booking: " + booking);
3. List bookings

System.out.println("Bookings for guest 1:");
for (Booking b : system.getBookingsForGuest(1)) {
    System.out.println(b);
}

System.out.println("Bookings for accommodation 1:");
for (Booking b : system.getBookingsForAccommodation(1)) {
    System.out.println(b);
}

4. Attempt a conflicting booking

Booking conflict = system.createBooking(
        1,
        1,
        LocalDate.of(2025, 12, 12),  // overlaps 10–15 Dec
        LocalDate.of(2025, 12, 13)
);
// Expected: system logs/throws an error or returns null, and does not add the booking.
This demonstrates the no double-booking logic clearly during the live demo.

# OOP Design Notes 
This project is built with object-oriented programming. Each real-world concept is a class: Host, Guest, Accommodation, Booking, and a BookingSystem that coordinates them.

I’m using encapsulation by keeping the lists of hosts, guests, accommodations and bookings private inside BookingSystem, and only exposing methods like createBooking or getBookingsForGuest.
I’m also using composition: a Booking is made from a Guest and an Accommodation, and BookingSystem is composed of lists of all these objects. This makes it easy to extend; for example, in a later sprint I could add payment details or cancellation logic without rewriting the core classes.”

# About
Simple room booking prototype for Software Development 3 (University of Roehampton), Sprint 2. Focus: OOP design, basic booking workflow, and validation against double-booking.

<img width="468" height="647" alt="image" src="https://github.com/user-attachments/assets/a06d5997-26b7-4b0c-9c88-77e30abfbe3b" />

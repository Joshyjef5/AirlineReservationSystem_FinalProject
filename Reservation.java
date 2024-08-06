//Reservation.java
package com.airline.reservation;

public class Reservation {
    private String reservationId;
    private Flight flight;
    private int numberOfSeats;
    private String passengerName;

    public Reservation(String reservationId, Flight flight, int numberOfSeats, String passengerName) {
        this.reservationId = reservationId;
        this.flight = flight;
        this.numberOfSeats = numberOfSeats;
        this.passengerName = passengerName;
        flight.bookSeat(numberOfSeats);
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Passenger: " + passengerName +
                ", Flight: " + flight.getFlightNumber() + ", Seats: " + numberOfSeats;
    }
}

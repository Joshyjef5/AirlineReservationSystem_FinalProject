// Flight.java
package com.airline.reservation;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    public Flight(String flightNumber, String origin, String destination, int totalSeats, double fare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public void bookSeat(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Origin: " + origin + ", Destination: " + destination +
                ", Available Seats: " + availableSeats + ", Fare: $" + fare;
    }
}

package com.airline.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Reservation> reservations;

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeFlights();
    }

    private void initializeFlights() {
        flights.add(new Flight("AI101", "New York", "London", 200, 500.00));
        flights.add(new Flight("AI102", "Los Angeles", "Paris", 150, 650.00));
        flights.add(new Flight("AI103", "Tokyo", "Sydney", 100, 700.00));
    }

    public void searchFlights(String origin, String destination) {
        System.out.println("Available flights from " + origin + " to " + destination + ":");
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(flight);
            }
        }
    }

    public void bookFlight(String flightNumber, int numberOfSeats, String passengerName) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                if (flight.getAvailableSeats() >= numberOfSeats) {
                    Reservation reservation = new Reservation("RES" + (reservations.size() + 1), flight, numberOfSeats, passengerName);
                    reservations.add(reservation);
                    System.out.println("Booking successful! Reservation ID: " + reservation);
                } else {
                    System.out.println("Not enough seats available.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    public void viewReservations() {
        System.out.println("Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAirline Reservation System");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    system.searchFlights(origin, destination);
                    break;
                case 2:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter number of seats: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    system.bookFlight(flightNumber, seats, passengerName);
                    break;
                case 3:
                    system.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


package mcr;

import java.util.*;

public class Flight {
    private String name;
    private int distance;
    private double ticketPrice;
    public Flight(String name, int distance, double ticketPrice) {
        this.name = name;
        this.distance = distance;
        this.ticketPrice = ticketPrice;
    }

    public int getDistance() {
        return distance;
    }

    public double getTicketBasePrice() {
        return ticketPrice;
    }


    public String toString() {
        return name + " (" + distance + " miles)";
    }
}

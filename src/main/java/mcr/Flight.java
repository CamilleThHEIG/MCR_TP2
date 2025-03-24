package mcr;

import java.util.*;

public class Flight {
    private String name;
    private int distance;
    private double ticketPrice;
    private List<Ticket> ticketTypes;
    public Flight(String name, int distance, double ticketPrice, List<Ticket> ticketTypes) {
        this.name = name;
        this.distance = distance;
        this.ticketPrice = ticketPrice;
        this.ticketTypes = ticketTypes;
    }

    public int getDistance() {
        return distance;
    }

    public double getTicketBasePrice() {
        return ticketPrice;
    }

    public Map<Ticket, Double> getTicketsPrice(){
        Map<Ticket, Double> map = new HashMap<>();
        for(Ticket t : ticketTypes){
            map.put(t,t.getFinalPrice(ticketPrice));
        }
        return map;
    }

    public String toString() {
        return name + " (" + distance + " miles)";
    }
}

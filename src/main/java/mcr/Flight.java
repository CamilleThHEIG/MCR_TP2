package mcr;

import java.util.LinkedList;
import java.util.List;

public class Flight {
    private String name;
    private int distance;

    private LinkedList<Ticket> tickets = new LinkedList<>();
    public Flight(String name, int distance, double ticketPrice, LinkedList<TicketType> tickets) {
        this.name = name;
        this.distance = distance;
        for(TicketType t : tickets){
            this.tickets.add(new Ticket(ticketPrice,t));
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return name + " (" + distance + " miles)";
    }
}

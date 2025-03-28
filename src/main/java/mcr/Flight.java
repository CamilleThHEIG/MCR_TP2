package mcr;

import java.util.LinkedList;
import java.util.List;

public class Flight {
    private final String name;
    private final int distance;

    private final LinkedList<Ticket> tickets = new LinkedList<>();

    /**
     * Constructor for Flight
     * @param name name of the flight
     * @param distance distance of the flight ot reach destination
     * @param ticketPrice ticket price of the flight
     * @param tickets ticket list of the flight
     */
    public Flight(String name, int distance, double ticketPrice, LinkedList<TicketType> tickets) {
        this.name = name;
        this.distance = distance;
        for(TicketType t : tickets){
            this.tickets.add(new Ticket(ticketPrice, t));
        }
    }

    /**
     * Gets the ticket list of the flight.
     * @return the ticket list of the flight.
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Gets the distance of the flight.
     * @return the distance of the flight.
     */
    public int getDistance() {
        return distance;
    }
    /**
     * toString method for the flight
     * @return string containing the flight information
     */
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}

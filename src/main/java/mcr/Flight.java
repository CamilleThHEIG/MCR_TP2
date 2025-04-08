package mcr;

import java.util.LinkedList;
import java.util.List;

/**
 * Flight class. Instances we contain information from a flight.
 */
public class Flight {
    private final String name;
    private final int distance;

    private final LinkedList<Ticket> tickets = new LinkedList<>();

    /**
     * Constructor for Flight
     * @param name name of the flight
     * @param distance distance of the flight ot reach destination
     * @param ticketPrice ticket price of the flight
     */
    public Flight(String name, int distance, double ticketPrice) {
        this.name = name;
        this.distance = distance;
        this.tickets.add(new Ticket(ticketPrice, TicketType.First));
        this.tickets.add(new Ticket(ticketPrice, TicketType.Economy)); // Ex: Business coûte 2x Economy
        this.tickets.add(new Ticket(ticketPrice, TicketType.Business));
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

package mcr;

/**
 * Represents a flight ticket with base price and type
 * Manage the calculation of final price based on ticket type
 */
public class Ticket {
    private final double basePrice;
    private final TicketType ticketType;

    /**
     * Constructor for the ticket
     * @param basePrice base price of the ticket
     * @param ticketType type of the ticket
     */
    public Ticket(double basePrice, TicketType ticketType) {
        this.basePrice = basePrice;
        this.ticketType = ticketType;
    }

    /**
     * Computes and returns the final price of the ticket.
     * @return the final price of the ticket
     */
    public double getFinalPrice() {
        return basePrice * ticketType.getPriceCoeff();
    }

    /**
     * Gets the type of the ticket.
     * @return type of the ticket.
     */
    public TicketType getTicketType() {
        return ticketType;
    }

    /**
     * toString method for the ticket
     * @return string containing the ticket information
     */
    public String toString(){
        return ticketType.toString() + " " + this.getFinalPrice();
    }
}

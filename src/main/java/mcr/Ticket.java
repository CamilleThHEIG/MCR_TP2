package mcr;

public class Ticket {
    private double basePrice;
    private TicketType ticketType;

    public Ticket(double basePrice, TicketType ticketType) {
        this.basePrice = basePrice;
        this.ticketType = ticketType;
    }

    public String toString(){
        return ticketType.toString() + " " + ticketType.getFinalPrice(basePrice);
    }
}

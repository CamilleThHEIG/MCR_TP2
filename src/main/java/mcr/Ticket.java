package mcr;

public class Ticket {
    private double basePrice;
    private TicketType ticketType;

    public Ticket(double basePrice, TicketType ticketType) {
        this.basePrice = basePrice;
        this.ticketType = ticketType;
    }

    public double getFinalPrice() {
        return basePrice * ticketType.getPriceCoeff();
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String toString(){
        return ticketType.toString() + " " + this.getFinalPrice();
    }
}

package mcr;

public class Flight {
    private String name;
    private int distance;
    private Ticket ticket;
    public Flight(String name, int distance, Ticket ticket) {
        this.name = name;
        this.distance = distance;
        this.ticket = ticket;
    }

    public String toString() {
        return name + " (" + distance + " miles)";
    }
}

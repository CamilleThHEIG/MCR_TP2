package mcr;


import mcr.display.MainWindow;
import mcr.account.Client;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Create exemple data
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();
        LinkedList<TicketType> tickets = new LinkedList<>();
        LinkedList<TicketType> tickets2 = new LinkedList<>();
        tickets.add(TicketType.Business);
        tickets.add(TicketType.First);
        tickets.add(TicketType.Economy);
        tickets2.add(TicketType.First);

        // Create flights
        Flight f1 = new Flight("a-310",200,50,tickets);
        Flight f2 = new Flight("A-320", 230, 20,tickets2);

        // Create clients
        clients.add(new Client("Bob", "Dylan"));
        clients.add(new Client("Alice", "Dylan"));

        // Add flights
        flights.add(f1);
        flights.add(f2);

        // Launch main window
        new MainWindow(clients, flights);
    }
}
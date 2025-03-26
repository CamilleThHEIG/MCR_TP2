package mcr;

import mcr.display.MainWindow;
import mcr.account.Client;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();
        LinkedList<Ticket> tickets = new LinkedList<>();
        LinkedList<Ticket> tickets2 = new LinkedList<>();
        Flight f1 = new Flight("a-310",200,50);
        Flight f2 = new Flight("A-320", 230, 20);

        Ticket t1 = new Ticket(f1.getTicketBasePrice(), TicketType.Business);
        Ticket t2 = new Ticket(f1.getTicketBasePrice(), TicketType.First);

        Ticket t3 = new Ticket(f1.getTicketBasePrice(), TicketType.Economy);
        Ticket t4 = new Ticket(f1.getTicketBasePrice(), TicketType.First);
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets2.add(t4);

        Client c = new Client("Bob", "Dylan");
        clients.add(new Client("Alice", "Dylan"));
        clients.add(c);

        flights.add(f1);
        flights.add(f2);

        new MainWindow(clients, flights);
    }
}
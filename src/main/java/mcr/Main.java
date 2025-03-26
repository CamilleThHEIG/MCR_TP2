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
        tickets.add(Ticket.Economy);
        tickets.add(Ticket.Business);
        tickets.add(Ticket.First);
        tickets2.add(Ticket.Business);
        Client c = new Client("Bob", "Dylan");
        clients.add(c);
        clients.add(new Client("Alice", "Dylan"));
        flights.add(new Flight("a-310",200,50,tickets));

        flights.add(new Flight("a-320",200,70,tickets2));
        new MainWindow(clients, flights);
    }
}
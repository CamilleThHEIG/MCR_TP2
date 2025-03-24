package mcr;

import mcr.MainWindow;
import mcr.account.Client;
import mcr.display.ClientDetailsWindow;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();

        clients.add(new Client("Bob", "Dylan"));
        clients.add(new Client("Alice", "Dylan"));
        flights.add(new Flight("a-310",200,Ticket.Economy));
        flights.add(new Flight("a-320",200,Ticket.Economy));



        MainWindow w = new MainWindow(clients, flights);

        Client c = new Client("johnny","depp");
        c.getAccount();


        new ClientDetailsWindow(3);
    }
}
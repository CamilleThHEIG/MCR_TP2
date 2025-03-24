package mcr;

import mcr.MainWindow;
import mcr.account.Client;
import mcr.display.ClientDetailsWindow;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();
        LinkedList<Ticket> tickets = new LinkedList<>();
        tickets.add(Ticket.Economy);
        tickets.add(Ticket.Business);

        clients.add(new Client("Alice", "Dylan"));
        flights.add(new Flight("a-310",200,50,tickets));
        flights.add(new Flight("a-320",200,70,tickets));



        MainWindow w = new MainWindow(clients, flights);

//        Flight f = new Flight("a-310",200,50, Ticket.Economy);
//        Client c = new Client("Bob", "Dylan");
//        c.addCredit(20000000);
//        c.bookWithCredits(f,Ticket.Economy);
//        System.out.println(c.getAccount().getAccountType());
//        c.bookWithCredits(f,Ticket.Economy);
//        c.bookWithCredits(f,Ticket.Economy);
//        c.bookWithCredits(f,Ticket.Economy);
//        c.bookWithCredits(f,Ticket.Economy);
//        c.bookWithCredits(f,Ticket.Economy);
//        System.out.println(c.getAccount().getAccountType());

    }
}
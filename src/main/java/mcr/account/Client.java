package mcr.account;

import mcr.Flight;
import mcr.Subscriber;
import mcr.Ticket;

import java.util.LinkedList;

public class Client implements Publisher{
    private String lastAction;
    private String firstName;
    private String lastName;
    private int id;
    private static int idCounter = 0;
    private Account account;
    private LinkedList<Subscriber> subscribers = new LinkedList<>();

    public Client(String firstName, String lastName) {
        this.account = new Account(this);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++idCounter;
    }

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public void addCredit(int credit){
        this.account.addCredit(credit);
        this.notifySubscribers();
    }

    public String getLastAction(){
        return lastAction;
    }

    public void bookWithCredits(Flight flight, Ticket ticket) {
        double cost = flight.getTicketBasePrice() * ticket.getPriceCoeff();
        if (this.account.getCredit() >= cost) {
            this.account.addCredit(cost * -1) ;
            this.account.setMiles(this.account.getMiles() + flight.getDistance() * ticket.getMilesCoeff());
            this.lastAction = "Booked " + flight + " class (credits)";
            this.notifySubscribers();
        } else {
            this.lastAction = "Not enough credits to book " + flight;
        }
    }

    public void bookWithMiles(Flight flight, Ticket ticket) {
        double cost = flight.getTicketBasePrice() * ticket.getPriceCoeff();
        if (this.account.getCredit() >= cost) {
            this.account.addCredit(cost * -1) ;
            this.account.setMiles(this.account.getMiles() + flight.getDistance() * ticket.getMilesCoeff());
        }
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public double getCredit(){
        return this.account.getCredit();
    }

    public double getMiles(){
        return this.account.getMiles();
    }
}

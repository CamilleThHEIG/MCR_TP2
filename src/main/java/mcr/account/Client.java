package mcr.account;

import mcr.Flight;
import mcr.Subscriber;
import mcr.Ticket;
import mcr.TicketType;

import java.util.LinkedList;

public class Client implements Publisher {
    private String lastAction;
    private final String firstName;
    private final String lastName;
    private final int id;
    private static int idCounter = 0;
    private final Account account;
    private final LinkedList<Subscriber> subscribers = new LinkedList<>();

    /**
     * Constructor for client. Client is is automatically granted a client id
     * @param firstName first name of the client
     * @param lastName last name of the client
     */
    public Client(String firstName, String lastName) {
        this.account = new Account(this);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++idCounter;
    }

    /**
     * Gets the account of the client
     * @return reference to the account of the client
     */
    public Account getAccount() {
        return account;
    }

    /**
     * toString method for the client
     * @return string containing the client's information
     */
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


    // TODO factorize the two book methods ?

    public void bookWithCredits(Flight flight, Ticket ticket) {
        double cost = ticket.getFinalPrice();
        if (this.account.getCredit() >= cost) {
            this.account.addCredit(cost * -1) ;
            this.account.setMiles(this.account.getMiles() + flight.getDistance() * this.account.getState().getMileCoeff());
            this.lastAction = "Booked " + flight + " in "+ ticket + " class using credits";
            this.notifySubscribers();
        } else {
            this.lastAction = "Not enough credits to book " + flight;
        }
    }

    public void bookWithMiles(Flight flight, Ticket ticket) {
        double cost = flight.getDistance() * ticket.getTicketType().getMilesCoeff();
        if (this.account.getMiles() >= cost) {
            this.account.setMiles(this.account.getMiles() - cost);
            this.lastAction = "Booked " + flight + " in "+ ticket + " class using miles";
            this.notifySubscribers();
        }
    }

    /**
     * Adds a subscriber the list of subscribers.
     * @param subscriber the subscriber to subscriber
     */
    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    /**
     * Notifies every subscriber from changes in the client.
     */
    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    /**
     * Gets the id of the client.
     * @return the id of the client.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the last name of the client
     * @return the last name of the client.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the first name of the client
     * @return the first name of the client.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the amount of credits from the client's account.
     * @return the client's credits.
     */
    public double getCredit(){
        return this.account.getCredit();
    }
    /**
     * Gets the amount of miles from the client's account.
     * @return the client's miles.
     */
    public double getMiles(){
        return this.account.getMiles();
    }
}

package mcr.account;

import mcr.Flight;
import mcr.Subscriber;
import mcr.Ticket;

import java.util.LinkedList;

/**
 * Client class. Clients are publishers and will notify the Windows when relevant information changes.
 */
public class Client implements Publisher {

    private String lastAction;
    private final String firstName;
    private final String lastName;
    private final int id;
    private static int idCounter = 0;
    private final Account account;
    private final LinkedList<Subscriber> subscribers = new LinkedList<>();

    public enum PaymentMethod {
        CREDITS, MILES
    }
    /**
     * Constructor for client. Client it is automatically granted a client id
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

    /**
     * Adds some credit to the client. This will notify the subscribers.
     * @param credit credit to be added to the client's account.
     */
    public void addCredit(int credit){
        this.account.addCredit(credit);
        this.notifySubscribers();
    }

    /**
     * Gets the client's last action String.
     * @return the client's last action String
     */
    public String getLastAction(){
        return lastAction;
    }

    /**
     * Book a flight with either cash or miles.
     * @param flight the flight to book for.
     * @param ticket The ticket type to book
     * @param paymentMethod The payment method (cash, miles)
     */
    public void book(Flight flight, Ticket ticket, PaymentMethod paymentMethod){
        double cost;
        String successMessage;
        boolean canPay;
        if (paymentMethod == PaymentMethod.CREDITS) {
            cost = ticket.getFinalPrice();
            canPay = this.account.getCredit() >= cost;
            successMessage = "Booked " + flight + " in " + ticket + " class using credits";
        } else {
            cost = flight.getDistance() * ticket.getTicketType().getMilesCoeff();
            canPay = this.account.getMiles() >= cost;
            successMessage = "Booked " + flight + " in " + ticket + " class using miles";
        }
        if (canPay) {
            if (paymentMethod == PaymentMethod.CREDITS) {
                this.account.addCredit(cost * -1);
                this.account.setMiles(this.account.getMiles() + flight.getDistance() * this.account.getState().getMileCoeff());
            } else {
                this.account.setMiles(this.account.getMiles() - cost);
            }
            this.lastAction = successMessage;
            this.notifySubscribers();
        } else {
            this.lastAction = "Not enough " + paymentMethod.toString().toLowerCase() + " to book " + flight;
        }
    }

    /**
     * Adds a subscriber to the list of subscribers.
     * @param subscriber the subscriber to subscribe
     */
    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Remove a subscriber from the list of subscribers.
     * @param subscriber the subscriber to unsubscribe
     */
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
     * Gets the full name of a client, meaning it's first name and it's last name together
     * @return the full name of the client.
     */
    public String getFullName(){
        return this.firstName + " " + this.lastName;
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

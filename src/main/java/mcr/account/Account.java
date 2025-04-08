package mcr.account;

/**
 * Represents a client account with miles, credits, and status state
 * Uses the State pattern to manage different account statuses
 */
public class Account{
    private AccountState state;
    private double miles;
    private int credit;
    private final Client client;

    /**
     * Creates a new account for a client with the silver status
     * @param client The client linked to this account
     */
    public Account(Client client){
        this.state = new Silver(this);
        this.client = client;
    }

    /**
     * Gets the miles of the account
     * @return the miles of the account
     */
    public double getMiles(){
        return miles;
    }

    /**
     * Sets the miles of the account. Can potentially change the account state according to the state changing rules
     * @param miles the number of miles to set
     */
    public void setMiles(double miles){
        this.state.checkForNewStateWithMiles(miles);
        this.miles = miles;
    }

    /**
     * Gets the credits of the account
     * @return the credits of the account
     */
    public double getCredit(){
        return credit;
    }

    /**
     * Adds some credits to the account
     * @param addedCredit the credit to be added
     */
    public void addCredit(double addedCredit){
        this.credit += addedCredit;     // TODO fix warning
        if(this.state instanceof Platinium)
            this.state.checkForPermanentPlatiniumUpgrade(this.credit);
    }

    /**
     * Gets the client the account is related to
     * @return reference to the client the account is related to
     */
    public Client getClient(){
        return client;
    }

    /**
     * Sets the state of the account
     * @param state instance of AccountState to set the class
     */
    public void setState(AccountState state){
        this.state = state;
    }

    /**
     * Gets the current state of the class
     * @return reference to the account state of the class
     */
    public AccountState getState(){
        return state;
    }

    /**
     * Gets the status of the account.
     * @return the status of the account.
     */
    public AccountStatus getAccountStatus(){
        return this.state.getStatus();
    }
}

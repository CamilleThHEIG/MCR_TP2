package mcr.account;

// TODO : could the AccountState be an internal class ?
public class Account{
    private AccountState state;
    private double miles;
    private int credit;
    private final Client client;

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
        this.state.setMiles(miles);
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
     * @param addedCredit
     */
    public void addCredit(double addedCredit){
        this.credit += addedCredit;
        this.state.setCredits(this.credit);
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
     * Gets the name of the current account state
     * @return the account type name
     */
    public String getAccountType(){
        // TODO is getSimpleName clean enough ??
        return this.state.getClass().getSimpleName();
    }
}

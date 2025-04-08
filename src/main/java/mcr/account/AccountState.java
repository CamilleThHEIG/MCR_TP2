package mcr.account;

/**
 * Abstract class for account states
 * Implements the State pattern for account status management
 */
public abstract class AccountState {
    private final Account account;
    /**
     * Creates a new account state
     * @param account The account this state belongs to
     */
    public AccountState(Account account){
        this.account = account;
    }

    /**
     * Handle miles changes and can trigger status change
     * @param miles Miles value
     */
    public abstract void checkForNewStateWithMiles(double miles);

    /**
     * Handle the permanent platinium upgrade when enough credit
     * @param credits Total credit
     */
    public void checkForPermanentPlatiniumUpgrade(int credits){}

    /**
     * Gets the account the state is linked to. Only used inside the class.
     * @return reference to the account the state is linked to.
     */
    protected Account getAccount(){
        return account;
    }

    /**
     * Gets the status of the AccountState.
     * @return status of the AccountState
     */
    public abstract AccountStatus getStatus();


    /**
     * Change account state and notify clients
     * @param c new state
     */
    protected void setAccountState(AccountState c) {
        this.getAccount().setState(c);
        this.getAccount().getClient().notifySubscribers();
    }

    /**
     * Gets the miles coefficient of the state (which is actually the one of his status.
     * @return the miles coefficient of the state.
     */
    public double getMileCoeff(){
        return this.getStatus().getMilesCoeff();
    }

}

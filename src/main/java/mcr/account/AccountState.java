package mcr.account;

/**
 * Abstract class for account states
 * Implements the State pattern for account status management
 */
public abstract class AccountState {
    private final Account account;
    protected double mileCoeff;

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

    protected Account getAccount(){
        return account;
    }

    public abstract AccountStatus getStatus();

    /**
     * Change account state and notify clients
     * @param c new state
     */
    protected void setAccountState(AccountState c) {
        this.getAccount().setState(c);
        this.getAccount().getClient().notifySubscribers();
    }

    public double getMileCoeff(){
        return mileCoeff;
    }
}

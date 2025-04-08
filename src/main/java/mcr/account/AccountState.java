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
    public abstract void checkForNewStateWithMiles(double miles);

    public void checkForPermanentPlatiniumUpgrade(int credits){}

    protected Account getAccount(){
        return account;
    }

    public abstract AccountStatus getStatus();


    protected void setAccountState(AccountState c) {
        this.getAccount().setState(c);
        this.getAccount().getClient().notifySubscribers();
    }

    public double getMileCoeff(){
        return mileCoeff;
    }
}

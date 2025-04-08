package mcr.account;


/**
 * Class that represents the Platinum state for an account
 */
public class Platinium extends AccountState {
    /**
     * Creates a Platinum state for an account
     * @param account The account this state belongs to
     */
    public Platinium(Account account) {
        super(account);
    }

    /**
     * Checks miles for possible status change
     * @param miles Current miles to check
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {
        if(miles < 10000) setAccountState(new Gold(this.getAccount()));
    }


    /**
     * Checks whether to permanently upgrade to state PermanentPlatinum. If the conditions are met (credit > 100000,
     * change will be automatically done.
     * @param credits credits to base the decisions on.
     */
    @Override
    public void checkForPermanentPlatiniumUpgrade(int credits) {
        if(credits > 100000)
            setAccountState(new PermanentPlatinium(this.getAccount()));
    }

    /**
     * Gets the status of the AccountState.
     * @return status of the AccountState
     */
    @Override
    public AccountStatus getStatus() {
        return AccountStatus.PLATINIUM;
    }

    /**
     * Get the mile coeff
     * @return mile coeff
     */
    @Override
    public double getMileCoeff() {
        return 1;
    }
}

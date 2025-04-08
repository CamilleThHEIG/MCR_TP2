package mcr.account;

/**
 * Class that represents the permanent Platinum state for an account
 */
public class PermanentPlatinium extends AccountState{
    /**
     * Creates a Permanent Platinum state for an account
     * @param account The account this state belongs to
     */
    public PermanentPlatinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    /**
     * Checks miles for possible status change
     * @param miles Current miles to check
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {

    }

    /**
     * Gets the status of the AccountState.
     * @return status of the AccountState
     */
    @Override
    public AccountStatus getStatus() {
        return AccountStatus.PLATINIUM;
    }
}

package mcr.account;

/**
 * Class that represents the Silver state for an account
 */
public class Silver extends AccountState {
    /**
     * Creates a Silver state for an account
     * @param account The account this state belongs to
     */
    public Silver(Account account) {
        super(account);
    }

    /**
     * Checks miles for possible status change
     * @param miles Current miles to check
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {
        if(miles >= 1000) setAccountState(new Gold(this.getAccount()));
    }

    /**
     * Gets the status of the AccountState.
     * @return status of the AccountState
     */
    @Override
    public AccountStatus getStatus() {
        return AccountStatus.SILVER;
    }
}

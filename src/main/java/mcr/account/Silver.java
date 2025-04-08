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
        this.mileCoeff = 0.1;
    }

    /**
     * Checks miles for possible status change
     * @param miles Current miles to check
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {
        if(miles >= 1000) setAccountState(new Gold(this.getAccount()));
    }

    @Override
    public AccountStatus getStatus() {
        return AccountStatus.SILVER;
    }
}

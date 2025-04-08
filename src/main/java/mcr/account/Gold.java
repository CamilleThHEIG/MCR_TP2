package mcr.account;


/**
 * Class that represents the Gold state for an account
 */
public class Gold extends AccountState {
    /**
     * Creates a Gold state for an account
     * @param account The account this state belongs to
     */
    public Gold(Account account) {
        super(account);
    }

    /**
     * Checks miles for possible status change
     * @param miles Current miles to check
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {
        if (miles < 1000) setAccountState(new Silver(this.getAccount()));
        else if(miles > 10000) setAccountState(new Platinium(this.getAccount()));
    }

    /**
     * Gets the status of the AccountState.
     * @return status of the AccountState
     */
    @Override
    public AccountStatus getStatus(){
        return AccountStatus.GOLD;
    }
}

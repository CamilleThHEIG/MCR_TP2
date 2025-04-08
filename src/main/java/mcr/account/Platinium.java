package mcr.account;


/**
 * Class that represents the Platinum state for an account
 */
public class Platinium extends AccountState {
    public Platinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    /**
     * Sets the miles of the account
     * @param miles number of miles to set
     */
    @Override
    public void checkForNewStateWithMiles(double miles) {
        if(miles < 10000) setAccountState(new Gold(this.getAccount()));
    }


    @Override
    public void checkForPermanentPlatiniumUpgrade(int credits) {
        if(credits > 100000)
            setAccountState(new PermanentPlatinium(this.getAccount()));

    }

    @Override
    public AccountStatus getStatus() {
        return AccountStatus.PLATINIUM;
    }
}

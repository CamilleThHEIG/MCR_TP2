package mcr.account;

/**
 * Class that represents the Silver state for an account
 */
public class Silver extends AccountState {
    public Silver(Account account) {
        super(account);
        this.mileCoeff = 0.1;
    }

    @Override
    public void setMiles(double miles) {
        if(miles >= 1000) setAccountState(new Gold(this.getAccount()));
    }

    @Override
    public AccountStatus getStatus() {
        return AccountStatus.SILVER;
    }
}

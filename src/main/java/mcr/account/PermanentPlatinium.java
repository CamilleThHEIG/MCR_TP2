package mcr.account;

public class PermanentPlatinium extends AccountState{
    public PermanentPlatinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    @Override
    public void checkForNewStateWithMiles(double miles) {

    }


    @Override
    public AccountStatus getStatus() {
        return AccountStatus.PLATINIUM;
    }
}

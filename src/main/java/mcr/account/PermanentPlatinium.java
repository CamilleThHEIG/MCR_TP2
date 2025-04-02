package mcr.account;

public class PermanentPlatinium extends AccountState{
    public PermanentPlatinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    @Override
    public void setMiles(double miles) {

    }

    @Override
    public String toString() {
        return "";
    }
}

package mcr.account;

public class Platinium extends AccountState {
    boolean permanent = false;
    public Platinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    @Override
    public void setMiles(double miles) {
        if(miles < 10000) setAccountState(new Gold(this.getAccount()));
    }
}

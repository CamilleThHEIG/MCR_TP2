package mcr.account;

public class Platinium extends AccountState {
    boolean permanent = false;
    public Platinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    @Override
    public void setMiles(double miles) {
        if(permanent)
            return;
        if(this.getAccount().getCredit() > 100000){
            permanent = true;
            return;
        }
        if(miles < 10000) setAccountState(new Gold(this.getAccount()));
    }
}

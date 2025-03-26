package mcr.account;

public class Gold extends AccountState {
    public Gold(Account account) {
        super(account);
        this.mileCoeff = 0.5;
    }

    @Override
    public void setMiles(double miles) {
        if (miles < 1000) setAccountState(new Silver(this.getAccount()));
        else if(miles > 10000) setAccountState(new Platinium(this.getAccount()));
    }
}

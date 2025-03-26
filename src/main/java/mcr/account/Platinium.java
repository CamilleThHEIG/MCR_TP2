package mcr.account;

public class Platinium extends AccountState {
    public Platinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    @Override
    public void setMiles(double miles) {
        if(miles < 10000){
            this.getAccount().setState(new Gold(this.getAccount()));
            this.getAccount().getClient().notifySubscribers();
        }
    }
}

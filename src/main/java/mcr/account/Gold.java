package mcr.account;

public class Gold extends AccountState {
    public Gold(Account account) {
        super(account);
        this.mileCoeff = 0.5;
    }

    @Override
    public void setMiles(double miles) {
        if (miles < 1000){
            this.getAccount().setState(new Silver(getAccount()));
            this.getAccount().getClient().notifySubscribers();
        } else if(miles > 10000){
            this.getAccount().setState(new Platinium(getAccount()));
            this.getAccount().getClient().notifySubscribers();
        }
    }
}

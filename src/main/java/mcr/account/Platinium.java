package mcr.account;

public class Platinium implements AccountState {
    private Account account;

    public Platinium(Account account) {
        this.account = account;
    }

    @Override
    public void setMiles(double miles) {
        if(miles < 10000){
            this.account.setState(new Gold(this.account));
            this.account.getClient().notifySubscribers();
        }
    }
}

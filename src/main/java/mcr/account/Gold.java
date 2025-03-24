package mcr.account;

public class Gold implements AccountState {
    private Account account;

    public Gold(Account account) {
        this.account = account;
    }

    @Override
    public void setMiles(double miles) {
        if(miles < 1000){
            this.account.setState(new Silver(account));
            this.account.getClient().notifySubscribers();
        } else if(miles > 10000){
            this.account.setState(new Platinium(account));
            this.account.getClient().notifySubscribers();
        }
    }
}

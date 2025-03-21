package mcr.account;

public class Silver implements AccountState {
    private Account account;

    public Silver(Account account) {
        this.account = account;
    }

    @Override
    public void setMiles(int miles) {
        if(miles > 1000){
            account.setState(new Gold(account));
        }
    }
}

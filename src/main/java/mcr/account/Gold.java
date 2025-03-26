package mcr.account;

public class Gold extends AccountState {
    public Gold(Account account) {
        super(account);
    }

    @Override
    public void setMiles(double miles) {
        if (miles < 1000){
            setAccountStateToSilver();
        } else if(miles > 10000){
            setAccountStateToPlatinum();
        }
    }
}

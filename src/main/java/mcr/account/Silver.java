package mcr.account;

public class Silver extends AccountState {
    public Silver(Account account) {
        super(account);
    }

    @Override
    public void setMiles(double miles) {
        if(miles > 1000){
            setAccountStateToSilver();
        }
    }
}

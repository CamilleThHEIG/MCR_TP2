package mcr.account;

public class Silver extends AccountState {
    public Silver(Account account) {
        super(account);
        this.mileCoeff = 0.1;
    }

    @Override
    public void setMiles(double miles) {
        if(miles > 1000){
            setAccountStateToSilver();
        }
    }
}

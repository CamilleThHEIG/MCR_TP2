package mcr.account;

public class Platinium extends AccountState {
    public Platinium(Account account) {
        super(account);
    }

    @Override
    public void setMiles(double miles) {
        if(miles < 10000){
            setAccountStateToGold();
        }
    }
}

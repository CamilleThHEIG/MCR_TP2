package mcr.account;

public abstract class AccountState {
    private final Account account;  //TODO not sure about final
    protected double mileCoeff;
    public AccountState(Account account){
        this.account = account;
    }
    public abstract void setMiles(double miles);
    protected Account getAccount(){
        return account;
    }

    public double getMileCoeff(){
        return mileCoeff;
    }
}

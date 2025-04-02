package mcr.account;

public abstract class AccountState {
    private final Account account;  //TODO not sure about final
    protected double mileCoeff;

    // private mystatut =

    public AccountState(Account account){
        this.account = account;
    }
    public abstract void setMiles(double miles);
    protected Account getAccount(){
        return account;
    }

    protected void setAccountState(AccountState c) {
        this.getAccount().setState(c);
        this.getAccount().getClient().notifySubscribers();
    }

    public double getMileCoeff(){
        return mileCoeff;
    }

    abstract public String getAccountType();
}

package mcr.account;

public abstract class AccountState {
    private final Account account;  //TODO not sure about final
    protected double mileCoeff;



    public AccountState(Account account){
        this.account = account;
    }
    public abstract void setMiles(double miles);

    public void setCredits(int credits){}

    protected Account getAccount(){
        return account;
    }

    public abstract AccountStatus getStatus();


    protected void setAccountState(AccountState c) {
        this.getAccount().setState(c);
        this.getAccount().getClient().notifySubscribers();
    }

    public double getMileCoeff(){
        return mileCoeff;
    }
}

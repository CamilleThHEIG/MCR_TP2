package mcr.account;

public abstract class AccountState {
    private final Account account;  //TODO not sure about final
    public AccountState(Account account){
        this.account = account;
    }
    public abstract void setMiles(double miles);
    protected Account getAccount(){
        return account;
    }

    // TODO these three can be even more factorized if I'm not wrong
    protected void setAccountStateToSilver(){
        this.getAccount().setState(new Silver(this.getAccount()));
        this.getAccount().getClient().notifySubscribers();
    }

    protected void setAccountStateToGold(){
        this.getAccount().setState(new Gold(this.getAccount()));
        this.getAccount().getClient().notifySubscribers();
    }

    protected void setAccountStateToPlatinum(){
        this.getAccount().setState(new Platinium(this.getAccount()));
        this.getAccount().getClient().notifySubscribers();
    }
}

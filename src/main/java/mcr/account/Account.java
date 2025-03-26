package mcr.account;

public class Account{
    private AccountState state;
    private double miles;
    private double credit;
    private Client client;

    public Account(Client client){
        this.state = new Silver(this);
        this.client = client;
    }

    public void setMiles(double miles){
        this.state.setMiles(miles);
        this.miles = miles;
    }

    public double getMiles(){
        return miles;
    }

    public double getCredit(){
        return credit;
    }

    public Client getClient(){
        return client;
    }

    public void addCredit(double addedCredit){
        this.credit += addedCredit;
    }

    public void setState(AccountState state){
        this.state = state;
    }

    public AccountState getState(){
        return state;
    }

    public String getAccountType(){
        return this.state.getClass().getSimpleName();
    }
}

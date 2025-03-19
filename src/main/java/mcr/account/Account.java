package mcr.account;

public class Account{
    private AccountState state;
    private int miles;
    private int money;

    public Account(){
        this.state = new Silver(this);
    }


    public void setMiles(int miles){
        this.miles = miles;

    }

    public void setState(AccountState state){
        this.state = state;
    }
}

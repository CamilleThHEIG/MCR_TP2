package mcr.account;


/**
 * Class that represents the Platinum state for an account
 */
public class Platinium extends AccountState {
    boolean permanent = false;
    public Platinium(Account account) {
        super(account);
        this.mileCoeff = 1;
    }

    /**
     * Sets the miles of the account
     * @param miles number of miles to set
     */
    @Override
    public void setMiles(double miles) {
        if (permanent)
            return;
        if (this.getAccount().getCredit() > 100000){
            permanent = true;
            return;
        }
        if(miles < 10000) setAccountState(new Gold(this.getAccount()));
    }

    public String toString(){return "PLATINUM";}
}

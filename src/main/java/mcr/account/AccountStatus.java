package mcr.account;

public enum AccountStatus {
    SILVER, GOLD, PLATINIUM;

    public String toString(){
        return this.name();
    }
}

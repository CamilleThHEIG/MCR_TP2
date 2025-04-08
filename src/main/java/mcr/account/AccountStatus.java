package mcr.account;

/**
 * Account status types
 */
public enum AccountStatus {
    SILVER, GOLD, PLATINIUM;

    /**
     * Returns status name as string.
     * @return Status name
     */
    public String toString(){
        return this.name();
    }
}

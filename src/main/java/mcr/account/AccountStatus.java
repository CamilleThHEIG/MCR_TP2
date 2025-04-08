package mcr.account;

/**
 * Account status types
 */
public enum AccountStatus {
    SILVER(0.1), GOLD(0.5), PLATINIUM(1);

    private final double coefficient;

    /**
     * Creates an AccountStatus.
     * @param milesCoeff Miles multiplier
     */
    AccountStatus(double milesCoeff) {
        this.coefficient = milesCoeff;
    }

    /**
     * Returns status name as string.
     * @return Status name
     */
    public String toString(){
        return this.name();
    }

    /**
     * Get the mile coeff
     * @return mile coeff
     */
    public double getMilesCoeff(){
        return this.coefficient;
    }
}

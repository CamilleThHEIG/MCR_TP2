package mcr;

/**
 * Defines different ticket types with price and miles coefficients
 */
public enum TicketType {
    Economy(1,1),
    Business(2,5),
    First(5,30);

    private final double priceCoeff;
    private final double milesCoeff;

    /**
     * Creates ticket type with coefficients.
     * @param priceCoeff Price multiplier
     * @param milesCoeff Miles multiplier
     */
    TicketType(double priceCoeff, double milesCoeff) {
        this.priceCoeff = priceCoeff;
        this.milesCoeff = milesCoeff;
    }

    public double getPriceCoeff() {
        return priceCoeff;
    }

    public double getMilesCoeff() {
        return milesCoeff;
    }

}

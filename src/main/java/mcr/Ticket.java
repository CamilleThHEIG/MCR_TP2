package mcr;

public enum Ticket {
    Economy(1,1),
    Business(2,5),
    First(5,30);

    private double priceCoeff;
    private double milesCoeff;
    Ticket(double priceCoeff, double milesCoeff) {
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

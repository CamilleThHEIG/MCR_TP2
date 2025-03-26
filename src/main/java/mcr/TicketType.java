package mcr;

public enum TicketType {
    Economy(1,1),
    Business(2,5),
    First(5,30);

    private double priceCoeff;
    private double milesCoeff;
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

    public double getFinalPrice(double basePrice){
        return basePrice*priceCoeff;
    }

    public String toString(double basePrice){
        return this.name() + " " + getFinalPrice(basePrice);
    }
}

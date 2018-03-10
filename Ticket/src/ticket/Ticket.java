package ticket;

public class Ticket {

    static final int PRICE_PER_KM = 25;
    private int distance;
    private String destination;
    private boolean validity;
    private double priceReduction;

    public Ticket(int distance, String destination, int priceReduction) {
        this.distance = distance;
        this.destination = destination;
        this.priceReduction = priceReduction;
        this.validity = true;
    }

    public double calculatePrice() {
        return  Math.round(25 * distance * (1 - priceReduction / 100));
    }

    public void use() {
        if(validity) {
            setValidity(false);
        } else {
            System.out.println("You can't use this ticket anymore.");
        }
    }

    public static int getPricePerKm() {
        return PRICE_PER_KM;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public double getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(int priceReduction) {
        this.priceReduction = priceReduction;
    }

    @Override
    public String toString() {
        return "Destination: " + getDestination() + " Distance: " + getDistance() + " Price reduction: " + getPriceReduction() + " Price: " + calculatePrice();
    }
}

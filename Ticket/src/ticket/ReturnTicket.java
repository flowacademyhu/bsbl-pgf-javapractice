package ticket;

public class ReturnTicket extends Ticket {

    private int numberOfUses;

    public ReturnTicket(int distance, String destination, int priceReduction) {
        super(distance, destination, priceReduction);
        this.numberOfUses = 0;
        setValidity(true);
    }

    public double calculatePrice() {
        return super.calculatePrice()*2;
    }

    public void use() {
        if(isValidity()) {
            if(numberOfUses < 2) {
                numberOfUses++;
            }
            if(numberOfUses == 2) {
                setValidity(false);
            }
        } else {
            System.out.println("You can't use this ticket anymore.");
        }

    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of uses: " + getNumberOfUses() + " Type: return";
    }
}

public class Bicycle extends Vehicle {

    public Bicycle(int weight) {
        super(weight, 40);
    }

    @Override
    public void starting() throws BrokenException {
        if(isBroken()) {
            throw new BrokenException("Your bike is broken, Saint.");
        } else {
            System.out.println("Let's hit the road, Saint.");
        }
    }

    @Override
    public String toString() {
        return  "type: bicycle, " + super.toString();
    }
}

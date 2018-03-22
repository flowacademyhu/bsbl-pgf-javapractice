public final class Car extends Vehicle implements Motorized {

    private int fuel;

    public Car(int weight, int maxSpeed) {
        super(weight, maxSpeed);
        this.fuel = 50;
    }

    @Override
    public void starting() throws NoGuzzolineException, BrokenException {
        if(isBroken() || getFuel() <= 0) {
            if(isBroken()) {
                throw new BrokenException("I need to repair her, Saint.");
            }
            if(getFuel() <= 0) {
                throw new NoGuzzolineException("She needs more juice, Saint.");
            }
        } else {
            System.out.println("She's ready to go.");
            setFuel(getFuel() - 10);
        }
    }

    @Override
    public void refueling(int fuel) {
        setFuel(getFuel() + fuel);
    }

    @Override
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "type: car, fuel " + getFuel() + " " + super.toString();
    }
}

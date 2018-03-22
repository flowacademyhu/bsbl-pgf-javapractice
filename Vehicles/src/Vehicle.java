public abstract class Vehicle {

    private int weight;
    private int maxSpeed;
    private boolean isBroken;

    public Vehicle(int weight, int maxSpeed) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public abstract void starting() throws BrokenException;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public String toString() {
        return  "weight=" + getWeight() +
                ", max speed=" + getMaxSpeed() +
                ", is it broken=" + isBroken();
    }
}

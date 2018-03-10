package vehicle;

public class Car {

    protected int power;
    protected int topSpeed;
    protected String type;

    public Car(int power, int topSpeed, String type) {
        this.power = power;
        this.topSpeed = topSpeed;
        this.type = type;
    }

    public float competitiveness() {
        return power + topSpeed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", topSpeed=" + topSpeed +
                ", type='" + type + '\'' +
                '}';
    }
}

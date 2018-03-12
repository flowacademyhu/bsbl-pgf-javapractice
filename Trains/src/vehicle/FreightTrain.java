package vehicle;

public class FreightTrain extends Train {

    private String cargo;
    private int weight;

    public FreightTrain(String startStation, String endStation, int distance, int averageSpeed, String cargo, int weight) {
        super(startStation, endStation, distance, averageSpeed);
        this.cargo = cargo;
        this.weight = weight;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Freight train Cargo: " + cargo + " Weight " + weight + " t";
    }
}

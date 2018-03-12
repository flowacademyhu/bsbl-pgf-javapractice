package vehicle;

public class PassengerTrain extends Train {

    private int stopsCount;

    public PassengerTrain(String startStation, String endStation, int distance, int averageSpeed, int stopsCount) {
        super(startStation, endStation, distance, averageSpeed);
        if(stopsCount > 1) {
            this.stopsCount = stopsCount;
        } else {
            System.out.println("The number of stops should be at least 2.");
        }
    }

    @Override
    public float asap() {
        return super.asap() + (getStopsCount() - 2) * 0.1f;
    }

    public int getStopsCount() {
        return stopsCount;
    }

    public void setStopsCount(int stopsCount) {
        if(stopsCount > 1) {
            this.stopsCount = stopsCount;
        } else {
            System.out.println("The number of stops should be at least 2.");
        }
    }

    @Override
    public String toString() {
        return "Passenger train Number of stops: " + stopsCount;
    }
}

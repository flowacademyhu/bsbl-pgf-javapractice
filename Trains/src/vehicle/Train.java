package vehicle;

public class Train {

    protected String startStation;
    protected String endStation;
    protected float distance;
    protected int averageSpeed;

    public Train(String startStation, String endStation, int distance, int averageSpeed) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    public Train() {

    }

    public float asap() {
        return distance / averageSpeed;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public String toString() {
        return "Starting station : " + startStation + " Ending station: " + endStation + " Distance: " + distance +
                " km Average speed: " + averageSpeed + " km/h";
    }
}

package vehicle;

public final class F1Car extends Car {

    private String pilot;
    private float settings;

    public F1Car(int power, int topSpeed, String type, String pilot, float settings) {
        super(power, topSpeed, type);
        this.pilot = pilot;
        this.settings = settings;
    }

    public float competitiveness() {
        return super.competitiveness() * settings;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public float getSettings() {
        return settings;
    }

    public void setSettings(float settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "F1Car{" +
                "pilot='" + pilot + '\'' +
                ", settings=" + settings +
                ", power=" + power +
                ", topSpeed=" + topSpeed +
                ", type='" + type + '\'' +
                '}';
    }
}

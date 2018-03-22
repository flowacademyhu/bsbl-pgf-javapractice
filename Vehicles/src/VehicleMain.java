import java.util.ArrayList;

public class VehicleMain {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Bicycle bike1 = new Bicycle(25);
        Bicycle bike2 = new Bicycle(15);
        bike2.setBroken(true);
        Car magnumOpus = new Car(1500, 200);
        Car interceptor = new Car(1200, 250);

        vehicleList.add(bike1);
        vehicleList.add(bike2);
        vehicleList.add(magnumOpus);
        vehicleList.add(interceptor);

        for(Vehicle v : vehicleList) {
            try {
                v.starting();
            } catch (NoGuzzolineException g) {
                g.printStackTrace();
            } catch (BrokenException b) {
                b.printStackTrace();
            }
        }


        Car pieceOfScrap = new Car(1300, 140);

        while(true) {
            try {
                pieceOfScrap.starting();
            } catch (NoGuzzolineException g) {
                g.printStackTrace();
                break;
            } catch (BrokenException b) {
                b.printStackTrace();
                break;
            }
        }
    }
}

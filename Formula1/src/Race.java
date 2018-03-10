import vehicle.*;

public class Race {

    public static void main(String[] args) {

        F1Car alonso = new F1Car(850, 370, "McLaren", "Alonso", 0.9f);
        F1Car verstappen = new F1Car(850, 380, "RedBull", "Verstappen", 0.95f);
        F1Car vettel = new F1Car(900, 385, "Ferrari", "Vettel", 0.90f);
        F1Car hamilton = new F1Car(920, 380, "Mercedes", "Hamilton", 0.85f);
        F1Car stroll = new F1Car(920, 370, "Williams", "Stroll", 0.8f);


        Car[] cars = {alonso, verstappen, vettel, hamilton, stroll};
        sortCars(cars);
        printCarArray(cars);

    }

    public static void printCar(Car car) {
        System.out.println(car);
    }

    public static void sortCars (Car[] cars) {
        boolean sorted = false;
        Car car;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < cars.length - 1; i++) {
                if (cars[i].competitiveness() < cars[i + 1].competitiveness()) {
                    car = cars[i + 1];
                    cars[i + 1] = cars[i];
                    cars[i] = car;
                    sorted = false;
                }
            }
        }
    }

    public static void printCarArray(Car[] cars) {
        for(int i = 0; i < cars.length; i++) {
            System.out.println("Position " + (i + 1) + ":");
            printCar(cars[i]);
            System.out.println("Competitiveness: " + cars[i].competitiveness());
        }
    }
}

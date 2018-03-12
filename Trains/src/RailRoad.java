import vehicle.*;
import java.util.*;

public class RailRoad {

    public static void main(String[] args) {

        ArrayList<Train> trainArray = new ArrayList<Train>();
        Train shortestTime = new Train();
        float min = Float.MAX_VALUE;


        for (int i = 0; i < args.length; i +=0) {
            if (args[i].equals("Freight")) {
                FreightTrain ft = new FreightTrain(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]),
                        Integer.parseInt(args[i + 4]), args[i + 5], Integer.parseInt(args[i + 6]));
                trainArray.add(ft);
                if(ft.asap() < min) {
                    min = ft.asap();
                    shortestTime = ft;
                }
                i += 7;
            } else if (args[i].equals("Passenger")) {
                PassengerTrain pt = new PassengerTrain(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]),
                        Integer.parseInt(args[i + 4]), Integer.parseInt(args[i + 5]));
                trainArray.add(pt);
                if(pt.asap() < min) {
                    min = pt.asap();
                    shortestTime = pt;
                }
                i += 6;
            }
        }

        for(int i = 0; i < trainArray.size(); i++) {
            System.out.println(trainArray.get(i));
            System.out.println(trainArray.get(i).asap());
        }
        System.out.println("The shortest travel time: " + shortestTime + " Time: " + min);
    }
}

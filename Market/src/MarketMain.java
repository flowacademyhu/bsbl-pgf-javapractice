import market.*;
import market.product.*;

public class MarketMain {
    public static void main(String[] args) {
        if(args.length < 11) {
            System.out.println("There aren't enough arguments.");
        } else {
            SuperGranny granny = new SuperGranny(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
            Customer customer = new Customer(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
            Fruit[] fruits = {new Fruit(Float.parseFloat(args[2]), args[3], args[4]),
                    new Fruit(Float.parseFloat(args[5]), args[6], args[7]),
                    new Fruit(Float.parseFloat(args[8]), args[9], args[10])};

            MarketMain market = new MarketMain();
            float customerSpending = market.bartering(customer, fruits);
            float grannySpending = market.bartering(granny, fruits);
            System.out.println(customerSpending);
            System.out.println(customer);
            System.out.println(grannySpending);
            System.out.println(granny);
            if(grannySpending < customerSpending) {
                System.out.println("It was worth it to bring granny along.");
            }

        }
    }

    public static float bartering(Customer customer, Fruit[] fruits) {
        float startMoney = customer.getMoney();
        float endMoney;
        for(Fruit fruit : fruits) {
            customer.buyFruit(fruit);
        }
        endMoney = customer.getMoney();
        return startMoney - endMoney;
    }
}

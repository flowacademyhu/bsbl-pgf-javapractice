package market;

import market.product.Fruit;

import java.util.Arrays;

public class Customer {

    private Fruit[] basket;
    private float money;
    private int fruitCount = 0;

    public Customer(int basketSize, float money) {
        this.basket = new Fruit[basketSize];
        this.money = money;
    }

    public void buyFruit(Fruit fruit) {
        if(getMoney() >= fruit.getPrice() && fruit.getColor().equals("green") && getFruitCount() < getBasket().length) {
            getBasket()[getFruitCount()] = fruit;
            setFruitCount(getFruitCount() + 1);
            setMoney(getMoney() - fruit.getPrice());
        } else if (getMoney() < fruit.getPrice()) {
            System.out.println("I don't have enough money to buy this fruit.");
        } else if (!fruit.getColor().equals("green")) {
            System.out.println("Sorry, I only want green fruit.");
        }
    }

    public Fruit[] getBasket() {
        return basket;
    }

    public void setBasket(Fruit[] basket) {
        this.basket = basket;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    @Override
    public String toString() {
        return "market.Customer{" +
                "basket=" + Arrays.toString(basket) +
                ", money=" + money +
                '}';
    }
}

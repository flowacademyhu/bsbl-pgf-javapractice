package market;

import market.product.Fruit;

public class SuperGranny extends Customer {

    private boolean canHaggle;

    public SuperGranny(int basketSize, float money) {
        super(basketSize, money * 0.8f);
        if(Math.random() < 0.5) {
            this.canHaggle = true;
        } else {
            this.canHaggle = false;
        }
    }

    public void buyFruit(Fruit fruit) {
        if(canHaggle && Math.random() < 0.75) {
            if(getMoney() >= fruit.getPrice() * 0.9f && !fruit.getColor().equals("red") && getFruitCount() < getBasket().length) {
                getBasket()[getFruitCount()] = fruit;
                setFruitCount(getFruitCount() + 1);
                setMoney(getMoney() - fruit.getPrice() * 0.9f);
                iToldYouSo();
            } else if (getMoney() < fruit.getPrice()) {
                System.out.println("I don't have enough money to buy this fruit.");
            } else if (!fruit.getColor().equals("green")) {
                System.out.println("Sorry, I only want green fruit.");
            }
        } else {
            if(getMoney() >= fruit.getPrice() && !fruit.getColor().equals("red") && getFruitCount() < getBasket().length) {
                getBasket()[getFruitCount()] = fruit;
                setFruitCount(getFruitCount() + 1);
                setMoney(getMoney() - fruit.getPrice());
            } else if (getMoney() < fruit.getPrice()) {
                System.out.println("I don't have enough money to buy this fruit.");
            } else if (!fruit.getColor().equals("green")) {
                System.out.println("Sorry, I only want green fruit.");
            }
        }
    }

    public void iToldYouSo() {
        System.out.println("My grandson told me I could haggle with you.");
    }

    public boolean isCanHaggle() {
        return canHaggle;
    }

    @Override
    public String toString() {
        return "SuperGranny{" +
                "canHaggle=" + canHaggle +
                '}' + super.toString();
    }
}

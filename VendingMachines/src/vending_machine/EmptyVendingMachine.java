package vending_machine;

public class EmptyVendingMachine {

    protected int money;
    protected int cupCount;
    protected boolean usable;

    public EmptyVendingMachine(int money, int cupCount, boolean usable) {
        this.money = money;
        this.cupCount = cupCount;
        this.usable = usable;
    }

    public void putMoney(int cash) {
        System.out.println("This machine is out of order.");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCupCount() {
        return cupCount;
    }

    public void setCupCount(int cupCount) {
        this.cupCount = cupCount;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return "This machine is usable: " + usable + ", Money: " + money;
    }
}

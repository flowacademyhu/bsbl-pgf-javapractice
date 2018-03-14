package vending_machine;

public class VendingMachine extends EmptyVendingMachine {

    protected boolean cold;

    public VendingMachine(int cupCount, boolean cold) {
        super(0, cupCount, true);
        this.cold = cold;
    }

    @Override
    public void putMoney(int cash) {
        int price = 95;
        if(cupCount < 1 || !usable) {
            System.out.println("Try again later.");
        } else if (cash < price) {
            System.out.println("You have insufficient funds.");
        } else if (cash >= price) {
            System.out.println("Here's your Sunset Sarsaparilla, fam. Your change: " + (cash - price)   );
            cupCount--;
            money += price;
        }
    }

    public boolean isCold() {
        return cold;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }

    @Override
    public String toString() {
        return super.toString() + ", This machines serves " + (cold?("cold"):("warm")) + " drinks";
    }
}

import exception.BadQuality;

public class Fruit implements Goods {

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public boolean stillGood() throws BadQuality {
        int number = (int)(Math.random() * 5) + 1;
        if(number % 2 == 0) {
            return true;
        } else {
            if(number == 3) {
                throw new BadQuality("This fruit is rotten, I wouldn't eat it.");
            }
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "F;" + getName();
    }
}

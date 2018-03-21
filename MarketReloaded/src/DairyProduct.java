import exception.BadQuality;

public class DairyProduct implements Goods {

    private String name;
    private long productionTime;
    private long goodUntil;

    public DairyProduct(String name, long productionTime, long goodUntil) {
        this.name = name;
        this.productionTime = productionTime / 1000;
        this.goodUntil = goodUntil;
    }

    @Override
    public boolean stillGood() throws BadQuality {
        long timeOfPurchase = (System.currentTimeMillis() / 1000);
        if(timeOfPurchase - getProductionTime() < getGoodUntil()) {
            return true;
        } else {
            throw new BadQuality("The product is expired.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(long productionTime) {
        this.productionTime = productionTime;
    }

    public long getGoodUntil() {
        return goodUntil;
    }

    public void setGoodUntil(long goodUntil) {
        this.goodUntil = goodUntil;
    }

    @Override
    public String toString() {
        return "D;" + getGoodUntil() + ";" + getProductionTime() + ";" + getName();
    }
}

public abstract class Hero {

    private String name;
    private float health;
    private float offensiveRating;
    private float defensiveRating;
    private int startAP;
    private int turnAP;
    private int currentAP;
    private float criticalChance;
    private float damageModifier;

    public Hero(String name, int strength, int dexterity, int intelligence, int constitution, int speed, int perception) {
        this.name = name;
        this.health = 100 + constitution * 10;
        this.offensiveRating = 0.5f + intelligence * 0.1f;
        this.defensiveRating = 0.5f + dexterity * 0.1f;
        this.startAP = (int)(4 + perception * 0.5f);
        this.turnAP = (int)(4 + speed * 0.5f);
        this.criticalChance = 0.2f + perception * 0.02f;
        this.damageModifier = 0.5f + strength * 0.1f;
        currentAP = startAP;
    }

    public abstract void Attack(Hero hero);

    public abstract void Spell(Hero hero);

    public abstract void Defend();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getOffensiveRating() {
        return offensiveRating;
    }

    public void setOffensiveRating(float offensiveRating) {
        this.offensiveRating = offensiveRating;
    }

    public float getDefensiveRating() {
        return defensiveRating;
    }

    public void setDefensiveRating(float defensiveRating) {
        this.defensiveRating = defensiveRating;
    }

    public int getStartAP() {
        return startAP;
    }

    public void setStartAP(int startAP) {
        this.startAP = startAP;
    }

    public int getTurnAP() {
        return turnAP;
    }

    public void setTurnAP(int turnAP) {
        this.turnAP = turnAP;
    }

    public int getCurrentAP() {
        return currentAP;
    }

    public void setCurrentAP(int currentAP) {
        this.currentAP = currentAP;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    public float getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public String toString() {
        return  "name: " + name +
                ", health: " + health +
                ", offensive rating: " + offensiveRating +
                ", defensive rating: " + defensiveRating +
                ", start AP: " + startAP +
                ", turn AP: " + turnAP +
                ", current AP: " + currentAP +
                ", critical chance: " + criticalChance +
                ", damage modifier: " + damageModifier;
    }
}

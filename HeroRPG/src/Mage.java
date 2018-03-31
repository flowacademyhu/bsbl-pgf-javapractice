public class Mage extends Hero{

    public Mage(String name, int strength, int dexterity, int intelligence, int constitution, int speed, int perception) {
        super(name, strength, dexterity, intelligence, constitution, speed, perception);
    }

    //TODO: rewrite the actions

    public void Attack(Hero hero) {
        if(getCurrentAP() >= 3) {
            setCurrentAP(getCurrentAP() - 3);
            if(Math.random() <= getCriticalChance()) {
                hero.setHealth(hero.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5) * 2);
            } else {
                hero.setHealth(hero.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5));
            }
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }
    }

    public void Spell(Hero hero) {
        if(getCurrentAP() >=5) {
            setCurrentAP(getCurrentAP() - 5);
            hero.setDamageModifier(getDamageModifier() * 0.3f);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Defend() {
        if(getCurrentAP() >= 4) {
            setCurrentAP(getCurrentAP() - 4);
            setHealth(getHealth() + 20);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }
    }

    @Override
    public String toString() {
        return "Mage{} " + super.toString();
    }
}

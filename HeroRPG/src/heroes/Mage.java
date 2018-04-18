package heroes;

import heroes.Hero;

public class Mage extends Hero {

    public Mage(String name, int strength, int dexterity, int intelligence, int constitution, int speed, int perception) {
        super(name, strength, dexterity, intelligence, constitution, speed, perception);
    }

    public void Attack(Hero enemy) {
        // Chance to hit is determined by the attacker's offensive and the defender's defensive rating
        if(getCurrentAP() >= 3) {
            setCurrentAP(getCurrentAP() - 3);
            if(Math.random() <= (getOffensiveRating() - enemy.getDefensiveRating() + 0.4f)) {
                if(Math.random() <= getCriticalChance()) {
                    // Critical damage: (15 - 22.5) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 11 + 5) * 1.5f);
                } else {
                    // Normal damage: (10 - 15) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 11 + 5));
                }
            } else {
                System.out.println("You missed.");
            }
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Spell(Hero enemy) {
        if(getCurrentAP() >= 6 && getSpellCooldown() == 0) {
            setCurrentAP(getCurrentAP() - 6);
            // Debuffs the enemy's defensive rating
            enemy.setDefensiveRating(getDefensiveRating() * 0.8f);
            // Can't use spell for the next 2 turns
            setSpellCooldown(3);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Heal() {
        if(getCurrentAP() >= 4) {
            setCurrentAP(getCurrentAP() - 4);
            // Heals the hero for 15 HP
            setHealth(getHealth() + 15);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }
    }

    @Override
    public String toString() {
        return "heroes.Mage{} " + super.toString();
    }
}

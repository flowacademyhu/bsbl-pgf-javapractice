package heroes;

import heroes.Hero;

public class Thief extends Hero {

    public Thief(String name, int strength, int dexterity, int intelligence, int constitution, int speed, int perception) {
        super(name, strength, dexterity, intelligence, constitution, speed, perception);
    }

    public void Attack(Hero enemy) {
        // Chance to hit is determined by the attacker's offensive and the defender's defensive rating
        if(getCurrentAP() >= 3) {
            setCurrentAP(getCurrentAP() - 3);
            if(Math.random() <= (getOffensiveRating() - enemy.getDefensiveRating() + 0.6f)) {
                if(Math.random() <= getCriticalChance()) {
                    // Critical damage: (15 - 30) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5) * 3);
                } else {
                    // Normal damage: (5 - 10) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5));
                }
            } else {
                System.out.println("You don't have enough action points to perform this action.");
            }
        } else {
            System.out.println("You missed.");
        }

    }

    public void Spell(Hero enemy) {
        if(getCurrentAP() >= 6 && getSpellCooldown() == 0) {
            setCurrentAP(getCurrentAP() - 6);
            // Does -15 HP worth of damage to the enemy
            enemy.setHealth(getHealth() - 15);
            // Can't use spell for the next 2 turns
            setSpellCooldown(3);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Heal() {
        if(getCurrentAP() >= 3) {
            setCurrentAP(getCurrentAP() - 3);
            // Heals the hero for 12 HP
            setHealth(getHealth() + 12);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }
    }

    @Override
    public String toString() {
        return "heroes.Thief{} " + super.toString();
    }
}


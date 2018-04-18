package heroes;

import heroes.Hero;

public class Warrior extends Hero {

    public Warrior(String name, int strength, int dexterity, int intelligence, int constitution, int speed, int perception) {
        super(name, strength, dexterity, intelligence, constitution, speed, perception);
    }

    public void Attack(Hero enemy) {
        // Chance to hit is determined by the attacker's offensive and the defender's defensive rating
        if(getCurrentAP() >= 3) {
            setCurrentAP(getCurrentAP() - 3);
            if(Math.random() <= (getOffensiveRating() - enemy.getDefensiveRating() + 0.5f)) {
                if(Math.random() <= getCriticalChance()) {
                    // Critical damage: (10 - 20) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5) * 2);
                } else {
                    // Normal damage: (5 - 10) * damage modifier
                    enemy.setHealth(enemy.getHealth() - getDamageModifier() * (int)(Math.random() * 6 + 5));
                }
            } else {
                System.out.println("You missed.");
            }
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Spell(Hero ownHero) {
        if(getCurrentAP() >= 6 && getSpellCooldown() == 0) {
            setCurrentAP(getCurrentAP() - 6);
            // Buffs the hero's attack damage
            ownHero.setDamageModifier(getDamageModifier() * 1.2f);
            // Can't use spell for the next 2 turns
            setSpellCooldown(3);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }

    }

    public void Heal() {
        if(getCurrentAP() >= 5) {
            setCurrentAP(getCurrentAP() - 5);
            // Heals the hero for 25 HP
            setHealth(getHealth() + 25);
        } else {
            System.out.println("You don't have enough action points to perform this action.");
        }
    }

    @Override
    public String toString() {
        return "heroes.Warrior{} " + super.toString();
    }
}

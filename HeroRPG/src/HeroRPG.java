import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeroRPG {

    JFrame frame = new JFrame("HeroRPG");
    private JPanel mainForm;
    private JPanel characterCreator;
    private JPanel nextPanel;

    //Character creation panel
    private JButton increaseStrength;
    private JButton increaseDexterity;
    private JButton increaseIntelligence;
    private JButton increaseConstitution;
    private JButton increaseSpeed;
    private JButton increasePerception;
    private JButton decreaseStrength;
    private JButton decreaseDexterity;
    private JButton decreaseIntelligence;
    private JButton decreaseConstitution;
    private JButton decreaseSpeed;
    private JButton decreasePerception;
    private JTextField strengthNumber;
    private JTextField dexterityNumber;
    private JTextField intelligenceNumber;
    private JTextField constitutionNumber;
    private JTextField speedNumber;
    private JTextField perceptionNumber;
    private JRadioButton warrior;
    private JRadioButton mage;
    private JRadioButton thief;
    private ButtonGroup group = new ButtonGroup();

    private JTextField nameField;
    private JButton createCharacter;
    private JTextField characterField;

    //Battle panel
    private JTextField nextField;
    private JTextField player1Stats;
    private JTextField player2Stats;
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField player1Health;
    private JTextField player2Health;
    private JTextField player1AP;
    private JTextField player2AP;
    private JButton attackButton;
    private JButton spellButton;
    private JButton healButton;
    private JButton endTurn;
    private JTextField battleLog;


    private static int spentAttributePoints;
    private Hero hero1;
    private Hero hero2;
    private enum Player {PLAYER1, PLAYER2}
    private Player player = Player.PLAYER1;

    static HeroRPG heroRPG = new HeroRPG();


    public static void main(String[] args) {
        heroRPG.frame.setContentPane(heroRPG.characterCreator);
        heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        heroRPG.frame.pack();
        heroRPG.frame.setVisible(true);
        heroRPG.group.add(heroRPG.warrior);
        heroRPG.group.add(heroRPG.mage);
        heroRPG.group.add(heroRPG.thief);
    }

    public HeroRPG() {
        increaseStrength.addActionListener(new IncreaseAttribute(Integer.parseInt(strengthNumber.getText()), strengthNumber));
        increaseDexterity.addActionListener(new IncreaseAttribute(Integer.parseInt(dexterityNumber.getText()), dexterityNumber));
        increaseIntelligence.addActionListener(new IncreaseAttribute(Integer.parseInt(intelligenceNumber.getText()), intelligenceNumber));
        increaseConstitution.addActionListener(new IncreaseAttribute(Integer.parseInt(constitutionNumber.getText()), constitutionNumber));
        increaseSpeed.addActionListener(new IncreaseAttribute(Integer.parseInt(speedNumber.getText()), speedNumber));
        increasePerception.addActionListener(new IncreaseAttribute(Integer.parseInt(perceptionNumber.getText()), perceptionNumber));
        decreaseStrength.addActionListener(new DecreaseAttribute(Integer.parseInt(strengthNumber.getText()), strengthNumber));
        decreaseDexterity.addActionListener(new DecreaseAttribute(Integer.parseInt(dexterityNumber.getText()), dexterityNumber));
        decreaseIntelligence.addActionListener(new DecreaseAttribute(Integer.parseInt(intelligenceNumber.getText()), intelligenceNumber));
        decreaseConstitution.addActionListener(new DecreaseAttribute(Integer.parseInt(constitutionNumber.getText()), constitutionNumber));
        decreaseSpeed.addActionListener(new DecreaseAttribute(Integer.parseInt(speedNumber.getText()), speedNumber));
        decreasePerception.addActionListener(new DecreaseAttribute(Integer.parseInt(perceptionNumber.getText()), perceptionNumber));
        createCharacter.addActionListener(new CreateCharacter());

        attackButton.addActionListener(new Attack());
        spellButton.addActionListener(new UseSpell());
        healButton.addActionListener(new Heal());
        endTurn.addActionListener(new EndTurn());
    }

    private class IncreaseAttribute implements ActionListener {
        private int value;
        private JTextField field;

        public IncreaseAttribute(int value, JTextField field) {
            this.value = value;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            value = Integer.parseInt(field.getText());
            if (value < 10 && spentAttributePoints < 40) {
                value++;
                field.setText(String.valueOf(value));
                spentAttributePoints++;
            }
        }
    }

    private class DecreaseAttribute implements ActionListener {
        private int value;
        private JTextField field;

        public DecreaseAttribute(int value, JTextField field) {
            this.value = value;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            value = Integer.parseInt(field.getText());
            if (Integer.parseInt(field.getText()) > 0 && spentAttributePoints > 0) {
                value--;
                field.setText(String.valueOf(value));
                spentAttributePoints--;
            }
        }
    }

    private class CreateCharacter implements ActionListener {

        public CreateCharacter() {
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (spentAttributePoints == 40 && !nameField.equals("")) {
                if (player == Player.PLAYER1) {
                    if(warrior.isSelected()) {
                        hero1 = new Warrior(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    } else if(mage.isSelected()) {
                        hero1 = new Mage(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    } else {
                        hero1 = new Thief(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    }
                    characterField.setText(hero1.toString());
                    player = Player.PLAYER2;
                    spentAttributePoints = 0;
                    strengthNumber.setText("0");
                    dexterityNumber.setText("0");
                    intelligenceNumber.setText("0");
                    constitutionNumber.setText("0");
                    speedNumber.setText("0");
                    perceptionNumber.setText("0");
                    nameField.setText("");
                } else {
                    if(warrior.isSelected()) {
                        hero2 = new Warrior(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    } else if(mage.isSelected()) {
                        hero2 = new Mage(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    } else {
                        hero2 = new Thief(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                                Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                                Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                    }
                    characterField.setText(hero2.toString());
                    heroRPG.frame.setContentPane(heroRPG.nextPanel);
                    heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    heroRPG.frame.pack();
                    heroRPG.frame.setVisible(true);
                    player1Stats.setText(hero1.toString());
                    player2Stats.setText(hero2.toString());
                    player1Name.setText(hero1.getName());
                    player2Name.setText(hero2.getName());
                    player1Health.setText(hero1.getHealth() + " HP");
                    player2Health.setText(hero2.getHealth() + " HP");
                    player1AP.setText(hero1.getCurrentAP() + " AP");
                    player2AP.setText(hero2.getCurrentAP() + " AP");
                    // The player with the higher offensive rating starts the game
                    // If they are equal player1 gets to be first
                    if (hero1.getOffensiveRating() >= hero2.getOffensiveRating()) {
                        player = Player.PLAYER1;
                    }
                }
            }
        }
    }

    private class Attack implements ActionListener {

        public Attack() {
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (player == Player.PLAYER1) {
                hero1.Attack(hero2);
                player2Health.setText(hero2.getHealth() + " HP");
                player1AP.setText(hero1.getCurrentAP() + " AP");
                battleLog.setText(hero1.getName() + " attacked " + hero2.getName());
            } else {
                hero2.Attack(hero1);
                player1Health.setText(hero1.getHealth() + " HP");
                player2AP.setText(hero2.getCurrentAP() + " AP");
                battleLog.setText(hero2.getName() + " attacked " + hero1.getName());
            }
        }
    }

    //TODO: implement for other classes
    private class UseSpell implements ActionListener {

        public UseSpell() {}

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (player == Player.PLAYER1) {
                if (hero1 instanceof Warrior) {
                    hero1.Spell(hero1);
                    player1AP.setText(hero1.getCurrentAP() + " AP");
                    battleLog.setText(hero1.getName() + " buffed their attack damage");
                } else if(hero1 instanceof Mage) {
                    hero1.Spell(hero2);
                    player1AP.setText(hero1.getCurrentAP() + " AP");
                    battleLog.setText(hero1.getName() + " debuffed " + hero2.getName() + "'s defensive rating");
                } else if(hero1 instanceof Thief) {
                    hero1.Spell(hero2);
                    player1AP.setText(hero1.getCurrentAP() + " AP");
                    battleLog.setText(hero1.getName() + " decreased " + hero2.getName() + "'s health");
                }
            } else {
                if (hero2 instanceof Warrior) {
                    hero2.Spell(hero2);
                    player2AP.setText(hero2.getCurrentAP() + " AP");
                    battleLog.setText(hero2.getName() + " buffed their attack damage");
                } else if(hero2 instanceof Mage) {
                    hero2.Spell(hero1);
                    player2AP.setText(hero2.getCurrentAP() + " AP");
                    battleLog.setText(hero2.getName() + " debuffed " + hero1.getName() + "'s defensive rating");
                } else if(hero1 instanceof Thief) {
                    hero2.Spell(hero1);
                    player2AP.setText(hero2.getCurrentAP() + " AP");
                    battleLog.setText(hero2.getName() + " decreased " + hero1.getName() + "'s health");
                }
            }
        }
    }

    private class Heal implements ActionListener {

        public Heal() {}

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(player == Player.PLAYER1) {
                hero1.Heal();
                player1AP.setText(hero1.getCurrentAP() + " AP");
                battleLog.setText(hero1.getName() + " healed themself");
            } else {
                hero2.Heal();
                player2AP.setText(hero2.getCurrentAP() + " AP");
                battleLog.setText(hero2.getName() + " healed themself");
            }
        }
    }

    private class EndTurn implements ActionListener {

        public EndTurn() {}

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (player == Player.PLAYER1) {
                hero1.setCurrentAP(hero1.getCurrentAP() + hero1.getTurnAP());
                hero1.setSpellCooldown(hero1.getSpellCooldown() - 1);
                player1AP.setText(hero1.getCurrentAP() + " AP");
                if(hero1.getHealth() <= 0) {
                    battleLog.setText(hero2.getName() + " won the game");
                }
                if(hero2.getHealth() <= 0) {
                    battleLog.setText(hero1.getName() + " won the game");
                }
                player = Player.PLAYER2;
            } else {
                hero2.setCurrentAP(hero2.getCurrentAP() + hero2.getTurnAP());
                hero1.setSpellCooldown(hero1.getSpellCooldown() - 1);
                player2AP.setText(hero2.getCurrentAP() + " AP");
                if(hero1.getHealth() <= 0) {
                    battleLog.setText(hero2.getName() + " won the game");
                }
                if(hero2.getHealth() <= 0) {
                    battleLog.setText(hero1.getName() + " won the game");
                }
                player = Player.PLAYER1;
            }
        }
    }
}

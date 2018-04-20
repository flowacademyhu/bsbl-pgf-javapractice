package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.actionlisteners.*;
import heroes.*;

public class HeroRPG {

    public JFrame frame = new JFrame("HeroRPG");
    private JPanel mainForm;
    public JPanel characterCreator;
    public JPanel battle;
    public JPanel end;

    //Character creation panel
    private JLabel title1;
    private JTextField unspentPoints;
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

    //Battle panel
    private JLabel title2;
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

    //End panel
    private JLabel title3;
    private JButton restartButton;
    private JButton exitButton;
    private JTextField result;

    public static int spentAttributePoints;
    public static Hero hero1;
    public static Hero hero2;
    public enum Player {PLAYER1, PLAYER2}
    public static Player player = Player.PLAYER1;

    public static HeroRPG heroRPG = new HeroRPG();


    public static void main(String[] args) {
        heroRPG.unspentPoints.setEditable(false);
        heroRPG.strengthNumber.setEditable(false);
        heroRPG.dexterityNumber.setEditable(false);
        heroRPG.intelligenceNumber.setEditable(false);
        heroRPG.constitutionNumber.setEditable(false);
        heroRPG.speedNumber.setEditable(false);
        heroRPG.perceptionNumber.setEditable(false);
        heroRPG.result.setEditable(false);
        heroRPG.frame.setContentPane(heroRPG.characterCreator);
        heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        heroRPG.frame.pack();
        heroRPG.frame.setMinimumSize(new Dimension(400, 500));
        heroRPG.frame.setVisible(true);
        heroRPG.group.add(heroRPG.warrior);
        heroRPG.group.add(heroRPG.mage);
        heroRPG.group.add(heroRPG.thief);
        heroRPG.unspentPoints.setText("Unspent attribute points: " + String.valueOf(40 - spentAttributePoints));
    }

    public HeroRPG() {
        increaseStrength.addActionListener(new IncreaseAttribute(Integer.parseInt(strengthNumber.getText()), strengthNumber, unspentPoints));
        increaseDexterity.addActionListener(new IncreaseAttribute(Integer.parseInt(dexterityNumber.getText()), dexterityNumber, unspentPoints));
        increaseIntelligence.addActionListener(new IncreaseAttribute(Integer.parseInt(intelligenceNumber.getText()), intelligenceNumber, unspentPoints));
        increaseConstitution.addActionListener(new IncreaseAttribute(Integer.parseInt(constitutionNumber.getText()), constitutionNumber, unspentPoints));
        increaseSpeed.addActionListener(new IncreaseAttribute(Integer.parseInt(speedNumber.getText()), speedNumber, unspentPoints));
        increasePerception.addActionListener(new IncreaseAttribute(Integer.parseInt(perceptionNumber.getText()), perceptionNumber, unspentPoints));

        decreaseStrength.addActionListener(new DecreaseAttribute(Integer.parseInt(strengthNumber.getText()), strengthNumber, unspentPoints));
        decreaseDexterity.addActionListener(new DecreaseAttribute(Integer.parseInt(dexterityNumber.getText()), dexterityNumber, unspentPoints));
        decreaseIntelligence.addActionListener(new DecreaseAttribute(Integer.parseInt(intelligenceNumber.getText()), intelligenceNumber, unspentPoints));
        decreaseConstitution.addActionListener(new DecreaseAttribute(Integer.parseInt(constitutionNumber.getText()), constitutionNumber, unspentPoints));
        decreaseSpeed.addActionListener(new DecreaseAttribute(Integer.parseInt(speedNumber.getText()), speedNumber, unspentPoints));
        decreasePerception.addActionListener(new DecreaseAttribute(Integer.parseInt(perceptionNumber.getText()), perceptionNumber, unspentPoints));

        createCharacter.addActionListener(new CreateCharacter(unspentPoints, nameField, warrior, mage, thief, strengthNumber, dexterityNumber, intelligenceNumber,
                constitutionNumber, speedNumber, perceptionNumber, player1Stats, player2Stats, player1Name, player2Name,
                player1Health, player2Health, player1AP, player2AP));

        attackButton.addActionListener(new Attack(player1Health, player2Health, player1AP, player2AP, battleLog));
        spellButton.addActionListener(new UseSpell(player1Health, player2Health, player1AP, player2AP, battleLog));
        healButton.addActionListener(new Heal(player1Health, player2Health, player1AP, player2AP, battleLog));
        endTurn.addActionListener(new EndTurn(frame, player1AP, player2AP, battleLog, result));

        restartButton.addActionListener(new Restart(nameField, strengthNumber, dexterityNumber, intelligenceNumber,
                constitutionNumber, speedNumber, perceptionNumber, battleLog));
        exitButton.addActionListener(new Exit());
    }
}

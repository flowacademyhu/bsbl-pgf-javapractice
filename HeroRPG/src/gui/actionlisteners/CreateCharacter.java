package gui.actionlisteners;

import gui.HeroRPG;
import heroes.Hero;
import heroes.Mage;
import heroes.Thief;
import heroes.Warrior;
import gui.HeroRPG;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCharacter implements ActionListener {
    private JFrame frame;
    private JTextField unspentPoints;
    private JTextField nameField;
    private JRadioButton warrior;
    private JRadioButton mage;
    private JRadioButton thief;
    private JTextField strengthNumber;
    private JTextField dexterityNumber;
    private JTextField intelligenceNumber;
    private JTextField constitutionNumber;
    private JTextField speedNumber;
    private JTextField perceptionNumber;
    private JTextField player1Stats;
    private JTextField player2Stats;
    private JLabel whosTurn;
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField player1Health;
    private JTextField player2Health;
    private JTextField player1AP;
    private JTextField player2AP;
    private JLabel whichPlayer;

    public CreateCharacter(JFrame frame, JTextField unspentPoints, JTextField nameField, JRadioButton warrior, JRadioButton mage, JRadioButton thief,
                           JTextField strengthNumber, JTextField dexterityNumber, JTextField intelligenceNumber,
                           JTextField constitutionNumber, JTextField speedNumber, JTextField perceptionNumber,
                           JTextField player1Stats, JTextField player2Stats, JLabel whosTurn, JTextField player1Name,
                           JTextField player2Name, JTextField player1Health, JTextField player2Health, JTextField player1AP, JTextField player2AP, JLabel whichPlayer) {
        this.frame = frame;
        this.unspentPoints = unspentPoints;
        this.nameField = nameField;
        this.warrior = warrior;
        this.mage = mage;
        this.thief = thief;
        this.strengthNumber = strengthNumber;
        this.dexterityNumber = dexterityNumber;
        this.intelligenceNumber = intelligenceNumber;
        this.constitutionNumber = constitutionNumber;
        this.speedNumber = speedNumber;
        this.perceptionNumber = perceptionNumber;
        this.player1Stats = player1Stats;
        this.player2Stats = player2Stats;
        this.whosTurn = whosTurn;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Health = player1Health;
        this.player2Health = player2Health;
        this.player1AP = player1AP;
        this.player2AP = player2AP;
        this.whichPlayer = whichPlayer;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (HeroRPG.spentAttributePoints == 40 && !nameField.getText().equals("")) {
            if (HeroRPG.player == HeroRPG.Player.PLAYER1) {
                if(warrior.isSelected()) {
                    HeroRPG.hero1 = new Warrior(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                } else if(mage.isSelected()) {
                    HeroRPG.hero1 = new Mage(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                } else {
                    HeroRPG.hero1 = new Thief(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                }
                HeroRPG.player = HeroRPG.Player.PLAYER2;
                HeroRPG.spentAttributePoints = 0;
                strengthNumber.setText("0");
                dexterityNumber.setText("0");
                intelligenceNumber.setText("0");
                constitutionNumber.setText("0");
                speedNumber.setText("0");
                perceptionNumber.setText("0");
                nameField.setText("");
                unspentPoints.setText("Unspent attribute points: " + String.valueOf(40 - HeroRPG.spentAttributePoints));
                whichPlayer.setText("Player 2's character creator");
            } else {
                if(warrior.isSelected()) {
                    HeroRPG.hero2 = new Warrior(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                } else if(mage.isSelected()) {
                    HeroRPG.hero2 = new Mage(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                } else {
                    HeroRPG.hero2 = new Thief(nameField.getText(), Integer.parseInt(strengthNumber.getText()), Integer.parseInt(dexterityNumber.getText()),
                            Integer.parseInt(intelligenceNumber.getText()), Integer.parseInt(constitutionNumber.getText()),
                            Integer.parseInt(speedNumber.getText()), Integer.parseInt(perceptionNumber.getText()));
                }
                HeroRPG.heroRPG.frame.setContentPane(HeroRPG.heroRPG.battle);
                HeroRPG.heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                HeroRPG.heroRPG.frame.pack();
                HeroRPG.heroRPG.frame.setVisible(true);
                player1Stats.setText(HeroRPG.hero1.toString());
                player2Stats.setText(HeroRPG.hero2.toString());
                player1Name.setText(HeroRPG.hero1.getName());
                player2Name.setText(HeroRPG.hero2.getName());
                player1Health.setText(HeroRPG.hero1.getHealth() + " HP");
                player2Health.setText(HeroRPG.hero2.getHealth() + " HP");
                player1AP.setText(HeroRPG.hero1.getCurrentAP() + " AP");
                player2AP.setText(HeroRPG.hero2.getCurrentAP() + " AP");
                // The player with the higher offensive rating starts the game
                // If they are equal player1 gets to be first
                if (HeroRPG.hero1.getOffensiveRating() >= HeroRPG.hero2.getOffensiveRating()) {
                    HeroRPG.player = HeroRPG.Player.PLAYER1;
                    whosTurn.setText(HeroRPG.hero1.getName() + "'s turn");
                } else {
                    whosTurn.setText(HeroRPG.hero2.getName() + "'s turn");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Your character is not ready to be created.");
        }
    }
}
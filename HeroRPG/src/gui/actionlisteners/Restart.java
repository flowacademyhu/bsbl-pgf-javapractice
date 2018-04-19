package gui.actionlisteners;

import gui.HeroRPG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static gui.HeroRPG.heroRPG;

public class Restart implements ActionListener {
    private JTextField nameField;
    private JTextField strengthNumber;
    private JTextField dexterityNumber;
    private JTextField intelligenceNumber;
    private JTextField constitutionNumber;
    private JTextField speedNumber;
    private JTextField perceptionNumber;
    private JTextField battleLog;

    public Restart(JTextField nameField, JTextField strengthNumber, JTextField dexterityNumber,
                   JTextField intelligenceNumber, JTextField constitutionNumber,
                   JTextField speedNumber, JTextField perceptionNumber, JTextField battleLog) {
        this.nameField = nameField;
        this.strengthNumber = strengthNumber;
        this.dexterityNumber = dexterityNumber;
        this.intelligenceNumber = intelligenceNumber;
        this.constitutionNumber = constitutionNumber;
        this.speedNumber = speedNumber;
        this.perceptionNumber = perceptionNumber;
        this.battleLog = battleLog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HeroRPG.player = HeroRPG.Player.PLAYER1;
        HeroRPG.spentAttributePoints = 0;
        strengthNumber.setText("0");
        dexterityNumber.setText("0");
        intelligenceNumber.setText("0");
        constitutionNumber.setText("0");
        speedNumber.setText("0");
        perceptionNumber.setText("0");
        nameField.setText("");
        battleLog.setText("");
        heroRPG.frame.setContentPane(heroRPG.characterCreator);
        heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        heroRPG.frame.pack();
        heroRPG.frame.setVisible(true);
    }
}

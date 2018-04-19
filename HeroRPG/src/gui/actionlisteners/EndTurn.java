package gui.actionlisteners;

import gui.HeroRPG;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurn implements ActionListener {
    private JFrame frame;
    private JTextField player1AP;
    private JTextField player2AP;
    private JTextField battleLog;
    private JTextField result;

    public EndTurn(JFrame frame, JTextField player1AP, JTextField player2AP, JTextField battleLog, JTextField result) {
        this.frame = frame;
        this.player1AP = player1AP;
        this.player2AP = player2AP;
        this.battleLog = battleLog;
        this.result = result;
    }

    public void setPanel() {
        HeroRPG.heroRPG.frame.setContentPane(HeroRPG.heroRPG.end);
        HeroRPG.heroRPG.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HeroRPG.heroRPG.frame.pack();
        HeroRPG.heroRPG.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (HeroRPG.player == HeroRPG.Player.PLAYER1) {
            HeroRPG.hero1.setCurrentAP(HeroRPG.hero1.getCurrentAP() + HeroRPG.hero1.getTurnAP());
            HeroRPG.hero1.setSpellCooldown(HeroRPG.hero1.getSpellCooldown() - 1);
            player1AP.setText(HeroRPG.hero1.getCurrentAP() + " AP");
            if(HeroRPG.hero1.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero2.getName() + " won the game");
                result.setText(HeroRPG.hero2.getName() + " controlled by Player 2 won the game!");
                JOptionPane.showMessageDialog(frame, HeroRPG.hero1.getName() + " died!");
                setPanel();
            }
            if(HeroRPG.hero2.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero1.getName() + " won the game");
                result.setText(HeroRPG.hero1.getName() + " controlled by Player 2 won the game!");
                JOptionPane.showMessageDialog(frame, HeroRPG.hero2.getName() + " died!");
                setPanel();
            }
            HeroRPG.player = HeroRPG.Player.PLAYER2;
        } else {
            HeroRPG.hero2.setCurrentAP(HeroRPG.hero2.getCurrentAP() + HeroRPG.hero2.getTurnAP());
            HeroRPG.hero1.setSpellCooldown(HeroRPG.hero1.getSpellCooldown() - 1);
            player2AP.setText(HeroRPG.hero2.getCurrentAP() + " AP");
            if(HeroRPG.hero1.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero2.getName() + " won the game");
                result.setText(HeroRPG.hero2.getName() + " controlled by Player 2 won the game!");
                JOptionPane.showMessageDialog(frame, HeroRPG.hero1.getName() + " died!");
                setPanel();
            }
            if(HeroRPG.hero2.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero1.getName() + " won the game");
                result.setText(HeroRPG.hero1.getName() + " controlled by Player 2 won the game!");
                JOptionPane.showMessageDialog(frame, HeroRPG.hero2.getName() + " died!");
                setPanel();
            }
            HeroRPG.player = HeroRPG.Player.PLAYER1;
        }
    }
}
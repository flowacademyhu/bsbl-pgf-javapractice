package gui.actionlisteners;

import gui.HeroRPG;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurn implements ActionListener {

    private JTextField player1AP;
    private JTextField player2AP;
    private JTextField battleLog;

    public EndTurn(JTextField player1AP, JTextField player2AP, JTextField battleLog) {
        this.player1AP = player1AP;
        this.player2AP = player2AP;
        this.battleLog = battleLog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (HeroRPG.player == HeroRPG.Player.PLAYER1) {
            HeroRPG.hero1.setCurrentAP(HeroRPG.hero1.getCurrentAP() + HeroRPG.hero1.getTurnAP());
            HeroRPG.hero1.setSpellCooldown(HeroRPG.hero1.getSpellCooldown() - 1);
            player1AP.setText(HeroRPG.hero1.getCurrentAP() + " AP");
            if(HeroRPG.hero1.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero2.getName() + " won the game");
            }
            if(HeroRPG.hero2.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero1.getName() + " won the game");
            }
            HeroRPG.player = HeroRPG.Player.PLAYER2;
        } else {
            HeroRPG.hero2.setCurrentAP(HeroRPG.hero2.getCurrentAP() + HeroRPG.hero2.getTurnAP());
            HeroRPG.hero1.setSpellCooldown(HeroRPG.hero1.getSpellCooldown() - 1);
            player2AP.setText(HeroRPG.hero2.getCurrentAP() + " AP");
            if(HeroRPG.hero1.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero2.getName() + " won the game");
            }
            if(HeroRPG.hero2.getHealth() <= 0) {
                battleLog.setText(HeroRPG.hero1.getName() + " won the game");
            }
            HeroRPG.player = HeroRPG.Player.PLAYER1;
        }
    }
}
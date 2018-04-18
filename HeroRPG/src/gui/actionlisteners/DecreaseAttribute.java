package gui.actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.HeroRPG;

public class DecreaseAttribute implements ActionListener {
    private int value;
    private JTextField field;

    public DecreaseAttribute(int value, JTextField field) {
        this.value = value;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        value = Integer.parseInt(field.getText());
        if (Integer.parseInt(field.getText()) > 0 && HeroRPG.spentAttributePoints > 0) {
            value--;
            field.setText(String.valueOf(value));
            HeroRPG.spentAttributePoints--;
        }
    }
}
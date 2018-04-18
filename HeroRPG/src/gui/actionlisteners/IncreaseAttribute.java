package gui.actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.HeroRPG;

public class IncreaseAttribute implements ActionListener {
    private int value;
    private JTextField field;

    public IncreaseAttribute(int value, JTextField field) {
        this.value = value;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        value = Integer.parseInt(field.getText());
        if (value < 10 && HeroRPG.spentAttributePoints < 40) {
            value++;
            field.setText(String.valueOf(value));
            HeroRPG.spentAttributePoints++;
        }
    }
}

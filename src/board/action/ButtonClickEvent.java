package board.action;

import board.Field;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Field)actionEvent.getSource()).setClickStatus(true);
    }
}

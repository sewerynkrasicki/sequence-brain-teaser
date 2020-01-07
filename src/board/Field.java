package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Field extends JButton {
    private int idX;
    private int idY;
    private boolean clickStatus;


    public Field(int idX, int idY) {
        this.idX = idX;
        this.idY = idY;
    }

    public void setBlack() {
        this.setBackground(Color.BLACK);
    }

    public void setWhite() {
        this.setBackground(null);
    }

    public void setNumberField(String number) {
        this.setText(number);
        this.setRolloverEnabled(false);
        this.setFocusable(false);
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setContentAreaFilled(false);
        for (MouseListener ml : this.getMouseListeners()) {
            this.removeMouseListener(ml);
        }
    }

    public void setClickStatus(boolean status) {
        this.clickStatus = status;
    }

    public boolean getClickStatus() {
        return this.clickStatus;
    }

    public int getIdX() {
        return this.idX;
    }

    public int getIdY() {
        return this.idY;
    }

}

package board;

import board.action.InstructionPopUp;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public JButton instruction = new JButton("Instruction");

    public MenuBar() {
        setPreferredSize(new Dimension(50, 50));

        add(instruction);
        instruction.addActionListener(new InstructionPopUp());
    }
}
package board.action;

import board.Instruction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionPopUp implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Instruction.getInstance().setInstruction();
    }
}

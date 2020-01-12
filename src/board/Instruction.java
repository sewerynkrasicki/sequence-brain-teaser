package board;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Instruction extends JDialog {
    private static Instruction INSTANCE;

    //Singleton design pattern
    public static Instruction getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Instruction();
        }
        return INSTANCE;
    }


    private Instruction() {
    }

    JLabel jlText = new JLabel();
    ImageIcon imageIcon = new ImageIcon("./resources/image.gif");
    File file = new File("./resources/instruction.txt");

    public void setInstruction() {
        setTitle("Instruction");
        setLocationRelativeTo(null);
        setSize(500, 500);

        jlText.setIcon(imageIcon);
        jlText.setText("<html>" + readFromFile(file) + "</html>");
        add(jlText);
        setVisible(true);
    }

    public String readFromFile(File file) {
        String currString = "";
        String string = "";
        Scanner ins;
        {
            try {
                ins = new Scanner(file);
                while (ins.hasNextLine()) {
                    currString = "<br>" + ins.nextLine() + "</br>";
                    string = string.concat(currString);
                }
                ins.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return string;
    }
}

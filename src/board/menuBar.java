package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menuBar extends JMenuBar {

    JMenu m1 = new JMenu("Options");
    JMenu m2 = new JMenu("Help");
    JMenuItem m1i = new JMenuItem("Instruction");
    JMenuItem m2i = new JMenuItem("Return to main menu");

    menuBar() {
        add(m1);
        add(m2);
        m2.add(m1i);
        m1.add(m2i);
        setPreferredSize(new Dimension(50, 50));
        m2i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame b = new Menu();
                b.setVisible(true);
            }
        });
        m1i.addActionListener(new popUp());
    }
}

class popUp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
        JDialog dial = new dialog();
        dial.setSize(500, 500);
        dial.setVisible(true);
    }
}

class dialog extends JDialog {
    JLabel jlText = new JLabel();
    ImageIcon imageIcon = new ImageIcon("./resources/image.gif");
    File file = new File("./resources/instruction.txt");

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

    dialog() {
        jlText.setIcon(imageIcon);
        jlText.setText("<html>" + readFromFile(file) + "</html>");
        add(jlText);
        setTitle("Instruction");
        setLocationRelativeTo(null);
    }
}

class returnToMainMenu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFrame b = new Menu();
        b.setVisible(true);
    }
}


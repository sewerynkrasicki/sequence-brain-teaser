package board;

import javax.swing.*;
import java.awt.*;

public class OwnBoard extends JFrame {
    public JTextField size = new JTextField("Size of sequence");
    public JTextField north = new JTextField("North line of numbers (separated by space)");
    public JTextField south = new JTextField("South line of numbers (separated by space)");
    public JTextField east = new JTextField("East line of numbers (separated by space)");
    public JTextField west = new JTextField("West line of numbers (separated by space)");
    public JButton complete = new JButton("Create");
    public JPanel textPanel = new JPanel();

    public OwnBoard() {
        setLocationRelativeTo(null);
        setTitle("Creator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Add text fields
        textPanel.add(size);
        textPanel.add(north);
        textPanel.add(south);
        textPanel.add(east);
        textPanel.add(west);

        textPanel.add(complete);
        textPanel.setLayout(new GridLayout(6, 0));
        add(textPanel);
        setVisible(true);
    }

}

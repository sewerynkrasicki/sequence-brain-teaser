package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu extends JFrame {
    JButton but1 = new JButton("Play main game");
    JButton but2 = new JButton("Create your own game");
    JButton but3 = new JButton("EXIT");
    JPanel panel = new JPanel();
    public Menu()
    {
        dispose();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //main game
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                File file = new File("./resources/input.txt");
                fillBoard fillboard = new fillBoard(file);
                JFrame b = new Board(fillboard);
                b.setSize(1000,800);
                b.setVisible(true);
            }
        });

        //open ownBoard
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                JFrame own = new ownBoardFrame();
                own.setSize(1000,800);
                own.setVisible(true);
            }
        });

        //close program
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        //add buttons
        panel.add(but1);
        panel.add(but2);
        panel.add(but3);

        panel.setLayout(new GridLayout(3,0));

        setSize(200,300);
        add(panel, BorderLayout.CENTER);
    }
}
package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu extends JFrame {
    private JButton mainGame = new JButton("Play main game");
    private JButton ownGame = new JButton("Create your own game");
    private JButton exitGame = new JButton("EXIT");
    private JPanel panel = new JPanel();

    public Menu()
    {
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,300);
        setLocationRelativeTo(null);

        //main game
        mainGame.addActionListener(new createMainGame());

        //open ownBoard
        ownGame.addActionListener(new createOwnBoard());

        //close program
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        //add buttons
        panel.add(mainGame);
        panel.add(ownGame);
        panel.add(exitGame);
        panel.setLayout(new GridLayout(3,0));
        add(panel, BorderLayout.CENTER);
    }

    public class createMainGame implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
            File file = new File("./resources/input.txt");
            fillBoard fillboard = new fillBoard(file);
            JFrame b = new Board(fillboard);
        }
    }

    public class createOwnBoard implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
            JFrame own = new ownBoardFrame();
        }
    }

    public class closeBoard implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
        }
    }


}
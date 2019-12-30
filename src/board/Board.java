package board;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Board extends JFrame {
    JPanel plansza = new JPanel();
    JMenuBar mb = new menuBar();
    JButton checkTheWin = new JButton("Check win");
    JPanel bottomTextPanel = new JPanel();
    JTextField topText = new JTextField(10);
    JTextField leftSideText = new JTextField(10);
    JTextField rightSideText = new JTextField(10);
    JTextField bottomText = new JTextField(10);
    public Board(fillBoard fillboard){
        dispose();
        setTitle("Sequence");
        //center
        setLocationRelativeTo(null);
        add(plansza);
        plansza.setLayout(new GridLayout(fillboard.finalSize,fillboard.finalSize));

        //add menuBar and return to main menu in menuitem
        mb.getMenu(0).getItem(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                JFrame b = new Menu();
                b.setVisible(true);
            }
        });
        add(BorderLayout.NORTH, mb);


        for(int i = 0; i < fillboard.finalSize; i ++)
        {
            for(int j = 0 ; j < fillboard.finalSize; j++)
            {
                fillboard.tab[i][j].setMargin(new Insets(0,0,0,0));
                plansza.add(fillboard.tab[i][j]);
            }
        }
        checkTheWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game game = new Game();
                game.checkWin(fillboard.tab, fillboard.finalSize-2);
                topText.setText(game.getTOP());
                leftSideText.setText(game.getLEFT_SIDE());
                rightSideText.setText(game.getRIGHT_SIDE());
                bottomText.setText(game.getBOTTOM());
                if(topText.getText().equals("TOP: GOOD"))
                    topText.setForeground(Color.GREEN);
                else
                    topText.setForeground(Color.RED);
                if(leftSideText.getText().equals("LEFT: GOOD"))
                    leftSideText.setForeground(Color.GREEN);
                else
                    leftSideText.setForeground(Color.RED);
                if(rightSideText.getText().equals("RIGHT: GOOD"))
                    rightSideText.setForeground(Color.GREEN);
                else
                    rightSideText.setForeground(Color.RED);
                if(bottomText.getText().equals("BOTTOM: GOOD"))
                    bottomText.setForeground(Color.GREEN);
                else
                    bottomText.setForeground(Color.RED);
                if(game.getOVERALL().equals("WIN")) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "You solved the Puzzle!", "WINNER", JOptionPane.WARNING_MESSAGE);
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }

            }
        });
        bottomTextPanel.add(topText);
        bottomTextPanel.add(leftSideText);
        bottomTextPanel.add(rightSideText);
        bottomTextPanel.add(bottomText);
        add(bottomTextPanel, BorderLayout.SOUTH);
        add(checkTheWin, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Changing the color of board elements
    static class zmianaKlawiszy implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton but = (JButton) actionEvent.getSource();
            if(but.getBackground() == Color.BLACK)
                but.setBackground(null);
            else but.setBackground(Color.BLACK);

        }
    }
}

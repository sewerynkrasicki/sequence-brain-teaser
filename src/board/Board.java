package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Board extends JFrame {
    JPanel plansza = new JPanel();
    JMenuBar mb = new menuBar();

    public Board(fillBoard fillboard){
        dispose();
        //center
        setLocationRelativeTo(null);
        add(plansza);
        plansza.setLayout(new GridLayout(fillboard.finalSize,fillboard.finalSize));
        add(BorderLayout.NORTH, mb);
        for(int i = 0; i < fillboard.finalSize; i ++)
        {
            for(int j = 0 ; j < fillboard.finalSize; j++)
            {
                fillboard.tab[i][j].setMargin(new Insets(0,0,0,0));
                plansza.add(fillboard.tab[i][j]);
            }
        }
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

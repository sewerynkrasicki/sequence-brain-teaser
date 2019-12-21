package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    JPanel plansza = new JPanel();
    JMenuBar mb = new menuBar();
    fillBoard fillboard = new fillBoard();

    public Board(){
        //center
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.add(plansza);
        plansza.setLayout(new GridLayout(12,12));
        cp.add(BorderLayout.NORTH, mb);
        for(int i = 0; i < 12; i ++)
        {
            for(int j = 0 ; j < 12; j++)
            {
                fillboard.tab[i][j].setMargin(new Insets(0,0,0,0));
                plansza.add(fillboard.tab[i][j]);
            }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //Zmiana koloru elementow planszy
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

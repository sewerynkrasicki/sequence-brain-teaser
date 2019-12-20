package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Board extends JFrame {
    JPanel plansza = new JPanel();
    JPanel menu = new JPanel();
    fillBoard fillboard = new fillBoard();
    public Board(){
        //center
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.add(plansza);
        cp.add(menu);
        cp.setLayout(new GridLayout(1,2));
        plansza.setLayout(new GridLayout(12,12));


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
            if(but.getBackground() == Color.black)
                but.setBackground(null);
            else but.setBackground(Color.black);
        }
    }
}

package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    JPanel plansza = new JPanel();
    JPanel menu = new JPanel();
    JButton[][] tab = new JButton[10][10];

    public Board(){
        //center
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.add(plansza);
        cp.add(menu);
        cp.setLayout(new GridLayout(1,2));
        plansza.setLayout(new GridLayout(10,10));
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
            {
                tab[i][j]=new JButton("");
                (tab[i][j]).addActionListener(new zmianaKlawiszy());
                plansza.add(tab[i][j]);
            }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

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

package board;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fillBoard{
    public JButton[][] tab;
    public int finalSize;
    //set array of buttons
    public void setTab(JButton[][] tab)
    {
        this.tab = tab;
    }
    public JButton[][] getTab(){return tab;
    }
    //set size to fill
    public void setSize(int finalSize)
    {
        this.finalSize = finalSize;
    }

    //read numbers from file
    public Scanner readNumbers(File file){
        Scanner numbers = null;
        try {
            numbers = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numbers;

    }

    public fillBoard(File file) {
        Scanner numbers1 = readNumbers(file);
        int count = Integer.parseInt(numbers1.nextLine());
        setSize(count+2);
        int fill = count+1;
        JButton[][] arr = new JButton[finalSize][finalSize];
        setTab(arr);

        for (int i = 0; i < finalSize; i++) {
            for (int j = 0; j < finalSize; j++) {
                tab[i][j] = new JButton("");
            }
        }

        //north line of numbers1
        for (int i = 0; i < finalSize; i++) {
            if (numbers1.hasNextLine()) {
                tab[0][i].setText(numbers1.nextLine());
            }
            tab[0][i].setRolloverEnabled(false);
            tab[0][i].setFocusable(false);
            tab[0][i].setFocusPainted(false);
            tab[0][i].setBackground(Color.WHITE);
            tab[0][i].setContentAreaFilled(false);
            for (MouseListener ml : tab[0][i].getMouseListeners()) {
                tab[0][i].removeMouseListener(ml);
            }
        }

        //east line of numbers1
        for (int i = 0; i < finalSize; i++) {
            if (numbers1.hasNextLine()) {
                tab[i][fill].setText(numbers1.nextLine());
            }
            tab[i][fill].setRolloverEnabled(false);
            tab[i][fill].setFocusable(false);
            tab[i][fill].setFocusPainted(false);
            tab[i][fill].setBackground(Color.WHITE);
            tab[i][fill].setContentAreaFilled(false);
            for (MouseListener ml : tab[i][fill].getMouseListeners()) {
                tab[i][fill].removeMouseListener(ml);
            }
        }


        //south line of numbers1
        for (int i = 0; i < finalSize; i++) {
            if (numbers1.hasNextLine()) {
                tab[fill][i].setText(numbers1.nextLine());
            }
            tab[fill][i].setRolloverEnabled(false);
            tab[fill][i].setFocusable(false);
            tab[fill][i].setFocusPainted(false);
            tab[fill][i].setBackground(Color.WHITE);
            tab[fill][i].setContentAreaFilled(false);
            for (MouseListener ml : tab[fill][i].getMouseListeners()) {
                tab[fill][i].removeMouseListener(ml);
            }
        }

        //west line of numbers1
        for (int i = 1; i < finalSize; i++) {
            if (numbers1.hasNextLine()) {
                tab[i][0].setText(numbers1.nextLine());
            }
            tab[i][0].setRolloverEnabled(false);
            tab[i][0].setFocusable(false);
            tab[i][0].setFocusPainted(false);
            tab[i][0].setBackground(Color.WHITE);
            tab[i][0].setContentAreaFilled(false);
            for (MouseListener ml : tab[i][0].getMouseListeners()) {
                tab[i][0].removeMouseListener(ml);
            }
        }
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                tab[i][j] = new JButton("");
                (tab[i][j]).addActionListener(new Board.zmianaKlawiszy());
                /*
                (tab[i][j]).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Game game = new Game();
                        game.checkWin(tab, count);
                    }
                });
                 */
            }
        }
        numbers1.close();
    }
}

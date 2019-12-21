package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fillBoard{
    public JButton[][] tab = new JButton[12][12];

    public fillBoard() {
        File file = new File("./resources/input.txt");

        Scanner numbers = null;
        try {
            numbers = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                tab[i][j] = new JButton("");
            }
        }

        //south line of numbers
        for (int i = 0; i < 12; i++) {
            if (numbers != null) {
                tab[11][i].setText(numbers.nextLine());
            }
            tab[11][i].setRolloverEnabled(false);
            tab[11][i].setFocusable(false);
            tab[11][i].setFocusPainted(false);
            tab[11][i].setBackground(Color.WHITE);
            tab[11][i].setContentAreaFilled(false);
            for (MouseListener ml : tab[11][i].getMouseListeners()) {
                tab[11][i].removeMouseListener(ml);
            }
        }

        //east line of numbers
        for (int i = 0; i < 12; i++) {
            if (numbers != null) {
                tab[i][11].setText(numbers.nextLine());
            }
            tab[i][11].setRolloverEnabled(false);
            tab[i][11].setFocusable(false);
            tab[i][11].setFocusPainted(false);
            tab[i][11].setBackground(Color.WHITE);
            tab[i][11].setContentAreaFilled(false);
            for (MouseListener ml : tab[i][11].getMouseListeners()) {
                tab[i][11].removeMouseListener(ml);
            }
        }

        //north line of numbers
        for (int i = 0; i < 12; i++) {
            if (numbers != null) {
                tab[0][i].setText(numbers.nextLine());
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

        //west line of numbers
        for (int i = 1; i < 12; i++) {
            if (numbers != null) {
                tab[i][0].setText(numbers.nextLine());
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
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                tab[i][j] = new JButton("");
                (tab[i][j]).addActionListener(new Board.zmianaKlawiszy());
            }
        }
        if (numbers != null) {
            numbers.close();
        }
    }
}

package board;

import board.action.ButtonClickEvent;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    public JPanel board = new JPanel();
    public JPanel bottomTextPanel = new JPanel();
    public JTextField topScore = new JTextField("TOP", 10);
    public JTextField bottomScore = new JTextField("BOTTOM", 10);
    public JTextField leftScore = new JTextField("LEFT", 10);
    public JTextField rightScore = new JTextField("RIGHT", 10);
    public JButton checkTheWin = new JButton("Check the win");
    public JMenuBar menuBar;
    public Field[][] fields;
    public int size;
    public JButton newGame, ownGame, saveGame, loadGame, previous, next;

    public Board(int size) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setTitle("Sequence");
        setResizable(false);

        this.size = size;
        fields = new Field[size][size];
        this.menuBar = new MenuBar();
        this.setMenuBar();
        initializeFields();
        add(board);

        bottomTextPanel.add(topScore);
        bottomTextPanel.add(leftScore);
        bottomTextPanel.add(rightScore);
        bottomTextPanel.add(bottomScore);

        add(BorderLayout.NORTH, menuBar);
        add(BorderLayout.EAST, checkTheWin);
        add(BorderLayout.SOUTH, bottomTextPanel);
        setVisible(true);
    }

    public void initializeFields() {
        board.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fields[i][j] = new Field(i, j);
                fields[i][j].addActionListener(new ButtonClickEvent());
                board.add(fields[i][j]);
            }
        }
    }

    public void setFieldColor(int x, int y, byte color) {
        switch (color) {
            case 0:
                fields[x][y].setWhite();
                break;
            case 1:
                fields[x][y].setBlack();
                break;
        }
    }

    public void setMenuBar() {
        newGame = new JButton("New Game");
        ownGame = new JButton("Own Game");
        saveGame = new JButton("Save Game");
        loadGame = new JButton("Load Game");
        previous = new JButton("Previous");
        next = new JButton("next");
        menuBar.add(newGame);
        menuBar.add(ownGame);
        menuBar.add(saveGame);
        menuBar.add(loadGame);
        menuBar.add(previous);
        menuBar.add(next);
    }

}
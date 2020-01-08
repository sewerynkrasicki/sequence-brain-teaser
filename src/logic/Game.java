package logic;

import board.Board;
import board.Field;
import logic.fileManagement.FileHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game {
    //SINGLETON DESGIN PATTERN
    private static Game INSTANCE;

    public static Game getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    private byte[][] fieldsStatus; // 0 - white, 1 - black
    private Board board;
    private History history;
    private FileHandler fileHandler;
    private int mainGameSize = 12;
    private int[] northLine = {2, 4, 2, 3, 1, 4, 7, 4, 2, 2};
    private int[] southLine = {7, 2, 5, 4, 4, 3, 1, 1, 4, 5};
    private int[] westLine = {3, 2, 3, 1, 8, 5, 3, 5, 1, 4};
    private int[] eastLine = {5, 3, 4, 4, 1, 3, 5, 3, 3, 2};

    private Game() {
        this.board = new Board(mainGameSize);
        this.fieldsStatus = new byte[mainGameSize][mainGameSize];
        this.history = new History();
        this.fileHandler = new FileHandler();
        for (int i = 1; i < mainGameSize - 1; i++) {
            for (int j = 1; j < mainGameSize - 1; j++) {
                board.fields[i][j].addChangeListener(new FieldListener());
            }
        }

        setNewGame();

        board.checkTheWin.addActionListener(new checkTheWin());
        board.previous.addActionListener(new PreviousAction());
        board.next.addActionListener(new NextAction());
        board.newGame.addActionListener(new NewGameAction());
        board.saveGame.addActionListener(new SaveGameAction());
        board.loadGame.addActionListener(new LoadGameAction());

        board.previous.setEnabled(false);
        board.next.setEnabled(false);
    }

    public void newGame() {
        for (int i = 1; i < mainGameSize - 1; i++) {
            for (int j = 1; j < mainGameSize - 1; j++) {
                this.fieldsStatus[i][j] = 0;
                this.board.setFieldColor(i, j, (byte) 0);
            }
        }

        history.clearHistory();
        board.previous.setEnabled(false);
        board.next.setEnabled(false);
    }


    private void setNewGame() {
        for (int i = 1; i < mainGameSize - 1; i++) {
            for (int j = 1; j < mainGameSize - 1; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }

        //Setting up north line of numbers
        board.fields[0][0].setNumberField("");
        board.fields[0][11].setNumberField("");
        for (int i = 1; i < mainGameSize - 1; i++) {
            this.board.fields[0][i].setNumberField(Integer.toString(northLine[i - 1]));
        }

        //Setting up south line of numbers
        board.fields[11][0].setNumberField("");
        for (int i = 1; i < mainGameSize - 1; i++) {
            this.board.fields[11][i].setNumberField(Integer.toString(southLine[i - 1]));
        }

        //Setting up west line of numbers
        for (int i = 1; i < mainGameSize - 1; i++) {
            this.board.fields[i][0].setNumberField(Integer.toString(westLine[i - 1]));
        }

        //Setting up east line of numbers
        board.fields[11][11].setNumberField("");
        for (int i = 1; i < mainGameSize - 1; i++) {
            this.board.fields[i][11].setNumberField(Integer.toString(eastLine[i - 1]));
        }
    }

    public byte[][] fieldStatusClone() {
        byte[][] clonedFields = new byte[mainGameSize][mainGameSize];
        for (int i = 1; i < mainGameSize - 1; i++) {
            System.arraycopy(fieldsStatus[i], 1, clonedFields[i], 1, mainGameSize - 1 - 1);
        }
        return clonedFields;
    }

    private Data getActualData() {
        return new Data(fieldStatusClone());
    }

    private void LoadData(Data data) {
        byte[][] fieldStatus = data.getFieldStatus();
        for (int i = 1; i < mainGameSize - 1; i++) {
            for (int j = 1; j < mainGameSize - 1; j++) {
                this.fieldsStatus[i][j] = fieldStatus[i][j];
                this.board.setFieldColor(i, j, fieldsStatus[i][j]);
            }
        }
    }

    //Listeners

    public class FieldListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            int x = ((Field) ce.getSource()).getIdX();
            int y = ((Field) ce.getSource()).getIdY();

            if (((Field) ce.getSource()).getClickStatus()) {
                if (fieldsStatus[x][y] == 0) {
                    history.addData(getActualData());
                    board.setFieldColor(x, y, (byte) 1);
                    fieldsStatus[x][y] = 1;
                } else {
                    history.addData(getActualData());
                    board.setFieldColor(x, y, (byte) 0);
                    fieldsStatus[x][y] = 0;
                }
                ((Field) ce.getSource()).setClickStatus(false);
                board.previous.setEnabled(history.isPreviousPossible());
            }
        }
    }

    public class checkTheWin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CheckWin checkWin = new CheckWin.Builder()
                    .northLine(northLine)
                    .southLine(southLine)
                    .eastLine(eastLine)
                    .westLine(westLine)
                    .fieldsStatus(fieldsStatus)
                    .build();
            if (checkWin.checkOverallWin()) {
                JOptionPane.showMessageDialog(null,
                        "You solved the Puzzle!", "Winner",
                        JOptionPane.WARNING_MESSAGE);
                newGame();
                history.clearHistory();
                board.previous.setEnabled(false);
                board.next.setEnabled(false);
            }
            if (checkWin.checkWinBlackTop())
                board.topScore.setForeground(Color.GREEN);
            else board.topScore.setForeground(Color.RED);
            if (checkWin.checkWinBlackSide())
                board.leftScore.setForeground(Color.GREEN);
            else board.leftScore.setForeground(Color.RED);
            if (checkWin.checkWinWhiteSide())
                board.rightScore.setForeground(Color.GREEN);
            else board.rightScore.setForeground(Color.RED);
            if (checkWin.checkWinWhiteBottom())
                board.bottomScore.setForeground(Color.GREEN);
            else board.bottomScore.setForeground(Color.RED);
        }
    }

    public class PreviousAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LoadData(history.getPreviousData(getActualData()));
            board.next.setEnabled(true);
            board.previous.setEnabled(history.isPreviousPossible());
        }
    }

    public class NextAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LoadData(history.getNextData(getActualData()));
            board.previous.setEnabled(true);
            board.next.setEnabled(history.isNextPossible());
        }
    }

    public class NewGameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            newGame();
        }
    }

    public class SaveGameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Save file");
            if (jfc.showSaveDialog(board) == JFileChooser.APPROVE_OPTION) {
                String path = jfc.getSelectedFile().getAbsolutePath();
                history.addData(getActualData());
                try {
                    fileHandler.Save(history, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class LoadGameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Load file");
            if (jfc.showSaveDialog(board) == JFileChooser.APPROVE_OPTION) {
                String path = jfc.getSelectedFile().getAbsolutePath();
                try {
                    History loadHistory = fileHandler.Load(path);
                    if (loadHistory.isPreviousPossible()) {
                        LoadData(loadHistory.getPreviousData(null));
                        history = loadHistory;
                        board.previous.setEnabled(history.isPreviousPossible());
                        board.next.setEnabled(history.isNextPossible());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package board;

import logic.Game;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    private JPanel _board = new JPanel();
    private JMenuBar _menuBar = new menuBar();
    private JButton _checkTheWin = new JButton("Check win");
    private JPanel _bottomTextPanel = new JPanel();
    private JTextField topScore = new JTextField("TOP", 10);
    private JTextField leftScore = new JTextField("LEFT-SIDE", 10);
    private JTextField rightScore = new JTextField("RIGHT-SIDE" ,10);
    private JTextField bottomScore = new JTextField("BOTTOM", 10);
    private JFileChooser jfcSave = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    private fillBoard fill;

    public fillBoard getFill() {
        return fill;
    }

    public void setFill(fillBoard fill) {
        this.fill = fill;
    }

    public Board(fillBoard fillboard){
        setFill(fillboard);
        setTitle("Sequence");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 800);

        //Grid Board
        add(_board);
        _board.setLayout(new GridLayout(fillboard.getSize(),fillboard.getSize()));

        //add menuBar and return to main menu in menuitem
        _menuBar.getMenu(0).getItem(0).addActionListener(new returnToMainMenu());
        add(BorderLayout.NORTH, _menuBar);


        for(int i = 0; i < fillboard.getSize(); i ++)
        {
            for(int j = 0 ; j < fillboard.getSize(); j++)
            {
                fillboard.getTab()[i][j].setMargin(new Insets(0,0,0,0));
                _board.add(fillboard.getTab()[i][j]);
            }
        }

        _checkTheWin.addActionListener(new checkWin());

        //ScorePanel
        _bottomTextPanel.add(topScore);
        _bottomTextPanel.add(leftScore);
        _bottomTextPanel.add(rightScore);
        _bottomTextPanel.add(bottomScore);
        add(_bottomTextPanel, BorderLayout.SOUTH);

        //Check win button
        add(_checkTheWin, BorderLayout.EAST);
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

    class returnToMainMenu implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
            JFrame b = new Menu();
            b.setVisible(true);
        }
    }

    class checkWin implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Game game = new Game();
            game.checkWin(getFill().getTab(), getFill().getSize()-2);
            if(game.getTOP())
                topScore.setForeground(Color.GREEN);
            else
                topScore.setForeground(Color.RED);
            if(game.getLEFT_SIDE())
                leftScore.setForeground(Color.GREEN);
            else
                leftScore.setForeground(Color.RED);
            if(game.getRIGHT_SIDE())
                rightScore.setForeground(Color.GREEN);
            else
                rightScore.setForeground(Color.RED);
            if(game.getBOTTOM())
                bottomScore.setForeground(Color.GREEN);
            else
                bottomScore.setForeground(Color.RED);
            if(game.getOVERALL()) {
                dispose();
                JOptionPane.showMessageDialog(null, "You solved the Puzzle!", "WINNER", JOptionPane.WARNING_MESSAGE);
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        }
    }
}

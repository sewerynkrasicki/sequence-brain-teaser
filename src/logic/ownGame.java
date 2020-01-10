package logic;

import board.ownBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

public class ownGame {
    private ownBoard ownboard;
    private int size;
    private int[] getNorth, getSouth, getWest, getEast;

    public ownGame()
    {
        ownboard = new ownBoard();
        ownboard.complete.addActionListener(new completeButton());
    }

    public void initializeOwnGame()
    {
        Game game = new Game(size, getNorth, getSouth, getEast, getWest);
    }

    class completeButton implements ActionListener
    {
        //Gets data from the form
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                size = Integer.parseInt(ownboard.size.getText());
                getNorth = Arrays.stream(ownboard.north.getText().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                getSouth = Arrays.stream(ownboard.south.getText().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                getWest = Arrays.stream(ownboard.west.getText().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                getEast = Arrays.stream(ownboard.east.getText().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                initializeOwnGame();
    }
}

}

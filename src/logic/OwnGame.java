package logic;

import board.OwnBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class OwnGame {
    private OwnBoard ownboard;
    private int size;
    private int[] getNorth, getSouth, getWest, getEast;

    public OwnGame() {
        ownboard = new OwnBoard();
        ownboard.complete.addActionListener(new completeButton());
    }

    private void initializeOwnGame() {
        Game game = new Game(size, getNorth, getSouth, getEast, getWest);
    }

    class completeButton implements ActionListener {
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
            ownboard.dispose();
        }
    }

}

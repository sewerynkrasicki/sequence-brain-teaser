package test;

import logic.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    int[] north = {2, 1 , 2, 2, 2};
    int[] south = {2, 1, 3, 2, 2};
    int[] east = {3, 2, 3, 1, 2};
    int[] west = {1, 1, 1, 4, 2};
    int size = 5;
    byte[][] fieldsStatus = new byte[7][7];

    @Test
    public void newGameTest_ShouldSetFieldStatusToNull()
    {
        Game game = new Game(size, north, south, east, west);
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[1][1] = (byte) 1;
        game.setFieldsStatus(fieldsStatus);
        game.newGame();
        Assert.assertEquals(0, game.getFieldsStatus()[1][1]);
    }

    @Test
    public void setNewGameTest_ShouldSetsNumbersOnTheEdges()
    {
        Game game = new Game(size, north, south, east, west);
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        game.setNewGame(north, south, west, east);
        Assert.assertEquals(2, Integer.parseInt(game.board.fields[0][1].getText()));
    }


}

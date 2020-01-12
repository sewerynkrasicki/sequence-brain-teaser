package test;

import board.Board;
import board.Field;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class BoardTest {

    @Test
    public void setFieldColorTest_ShouldChangeColorToBlackWhileByteIsEqualToOne() {
        Board board = new Board(3);
        board.setFieldColor(2, 2, (byte) 1);
        Assert.assertEquals(Color.BLACK, board.fields[2][2].getBackground());
    }
}
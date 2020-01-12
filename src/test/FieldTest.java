package test;

import board.Field;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class FieldTest {

    @Test
    public void getIdXTest_ShouldReturnGivenPosition() {
        Field field = new Field(5, 5);
        int x = field.getIdX();
        Assert.assertEquals(5, x);
    }

    @Test
    public void getIdYTest_ShouldReturnGivenPosition() {
        Field field = new Field(5, 5);
        int y = field.getIdX();
        Assert.assertEquals(5, y);
    }

    @Test
    public void setBlackTest_ShouldChangeFieldColorToBlack() {
        Field field = new Field(5, 5);
        field.setBlack();
        Color color = Color.BLACK;

        Assert.assertEquals(color, field.getBackground());
    }

    @Test
    public void setWhiteTest_ShouldChangeFieldColorToNull() {
        Field field = new Field(5, 5);
        field.setBlack();
        field.setWhite();

        Assert.assertEquals(null, field.getBackground());
    }

    @Test
    public void setClickStatusTest_ShouldReturnClickStatus() {
        Field field = new Field(5, 5);
        field.setClickStatus(true);

        Assert.assertEquals(true, field.getClickStatus());
    }
}
package test;

import logic.Data;
import logic.History;
import org.junit.Assert;
import org.junit.Test;

public class HistoryTest {
    byte[][] fieldsStatus = new byte[7][7];
    int[] north = {2, 1, 2, 2, 2};
    int[] south = {2, 1, 3, 2, 2};
    int[] east = {3, 2, 3, 1, 2};
    int[] west = {1, 1, 1, 4, 2};
    int size = 5;

    Data data = new Data.Builder()
            .size(size)
            .northLine(north)
            .southLine(south)
            .eastLine(east)
            .westLine(west)
            .fieldStatus(fieldsStatus)
            .build();

    Data data1 = new Data.Builder()
            .size(4)
            .northLine(north)
            .southLine(south)
            .eastLine(east)
            .westLine(west)
            .fieldStatus(fieldsStatus)
            .build();

    @Test
    public void addDataAndCheckDataTest_ShouldReturnAddedData() {
        History history = new History();
        history.addData(data);
        Assert.assertEquals(data, history.checkData());
    }

    @Test
    public void addDataWithoutClearTempTest_ShouldAddData() {
        History history = new History();
        history.addDataWithoutClearTemp(data);
        Assert.assertEquals(data, history.checkData());
    }

    @Test
    public void getPreviousDataTest_ShouldReturnPreviousData() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        history.getPreviousData(data1);
        Assert.assertEquals(data, history.checkData());
    }

    @Test
    public void getNextDataTest_ShouldReturnNextData() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        history.getPreviousData(data1);

        Assert.assertEquals(history.getNextData(data), data1);
    }

    @Test
    public void clearHistoryTest_ShouldClearStack() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        history.getPreviousData(data1);
        history.clearHistory();
        history.addData(data);
        Assert.assertEquals(data, history.checkData());
    }

    @Test
    public void isPreviousPossible_ShouldReturnTrueWhenNewDataAdded() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        Assert.assertTrue(history.isPreviousPossible());

    }

    @Test
    public void isPreviousPossible_ShouldReturnFalseWhenHistoryHasNoPreviousData() {
        History history = new History();
        Assert.assertFalse(history.isPreviousPossible());
    }

    @Test
    public void isNextPossible_ShouldReturnTrueWhenHistoryHasNextData() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        history.getPreviousData(data1);
        Assert.assertTrue(history.isNextPossible());
    }

    @Test
    public void isNextPossible_ShouldReturnFalseWhenHistoryHasNoNextData() {
        History history = new History();
        history.addData(data);
        history.addData(data1);
        Assert.assertFalse(history.isNextPossible());
    }

}

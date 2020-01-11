package test;

import logic.CheckWin;
import org.junit.Assert;
import org.junit.Test;

public class CheckWinTest {
    byte[][] fieldsStatus = new byte[7][7];
    int[] north = {2, 1 , 2, 2, 2};
    int[] south = {2, 1, 3, 2, 2};
    int[] east = {3, 2, 3, 1, 2};
    int[] west = {1, 1, 1, 4, 2};

    @Test
    public void checkWinBlackTopTest_ShouldReturnTrueWhenLongestSequenceIsTheSameSizeOrSmallerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[1][1] = (byte) 1;
        fieldsStatus[2][1] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertTrue(check.checkWinBlackTop());
    }

    @Test
    public void checkWinBlackTopTest_ShouldReturnFalseWhenLongestSequenceIsBiggerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[1][1] = (byte) 1;
        fieldsStatus[2][1] = (byte) 1;
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertFalse(check.checkWinBlackTop());
    }

    @Test
    public void checkWinBlackSideTest_ShouldReturnTrueWhenLongestSequenceIsTheSameSizeOrSmallerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[1][1] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertTrue(check.checkWinBlackSide());
    }

    @Test
    public void checkWinBlackSideTest_ShouldReturnFalseWhenLongestSequenceIsBiggerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[1][1] = (byte) 1;
        fieldsStatus[1][2] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertFalse(check.checkWinBlackSide());
    }

    @Test
    public void checkWinWhiteBottomTest_ShouldReturnTrueWhenLongestSequenceIsTheSameSizeOrSmallerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;
        fieldsStatus[2][2] = (byte) 1;
        fieldsStatus[4][2] = (byte) 1;
        fieldsStatus[4][3] = (byte) 1;
        fieldsStatus[5][3] = (byte) 1;
        fieldsStatus[1][4] = (byte) 1;
        fieldsStatus[4][4] = (byte) 1;
        fieldsStatus[5][4] = (byte) 1;
        fieldsStatus[2][5] = (byte) 1;
        fieldsStatus[3][5] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertTrue(check.checkWinWhiteBottom());
    }

    @Test
    public void checkWinWhiteBottomTest_ShouldReturnFalseWhenLongestSequenceIsBiggerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;
        fieldsStatus[2][2] = (byte) 1;
        fieldsStatus[4][2] = (byte) 1;
        fieldsStatus[4][3] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertFalse(check.checkWinWhiteBottom());
    }

    @Test
    public void checkWinWhiteSideTest_ShouldReturnTrueWhenLongestSequenceIsTheSameSizeOrSmallerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;
        fieldsStatus[2][2] = (byte) 1;
        fieldsStatus[4][2] = (byte) 1;
        fieldsStatus[4][3] = (byte) 1;
        fieldsStatus[5][3] = (byte) 1;
        fieldsStatus[1][4] = (byte) 1;
        fieldsStatus[4][4] = (byte) 1;
        fieldsStatus[5][4] = (byte) 1;
        fieldsStatus[2][5] = (byte) 1;
        fieldsStatus[3][5] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertTrue(check.checkWinWhiteSide());
    }

    @Test
    public void checkWinWhiteSideTest_ShouldReturnFalseWhenLongestSequenceIsBiggerThanNumber()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;
        fieldsStatus[2][2] = (byte) 1;


        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertFalse(check.checkWinWhiteSide());
    }

    @Test
    public void checkOverallWinTest_ShouldReturnTrueWhileAllChecksAreTrue()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }
        fieldsStatus[3][1] = (byte) 1;
        fieldsStatus[4][1] = (byte) 1;
        fieldsStatus[2][2] = (byte) 1;
        fieldsStatus[4][2] = (byte) 1;
        fieldsStatus[4][3] = (byte) 1;
        fieldsStatus[5][3] = (byte) 1;
        fieldsStatus[1][4] = (byte) 1;
        fieldsStatus[4][4] = (byte) 1;
        fieldsStatus[5][4] = (byte) 1;
        fieldsStatus[2][5] = (byte) 1;
        fieldsStatus[3][5] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertTrue(check.checkOverallWin());
    }

    @Test
    public void checkOverallWinTest_ShouldReturnFalseWhileOneOfChecksIsFalse()
    {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                this.fieldsStatus[i][j] = 0;
            }
        }

        fieldsStatus[4][3] = (byte) 1;
        fieldsStatus[5][3] = (byte) 1;
        fieldsStatus[1][4] = (byte) 1;
        fieldsStatus[4][4] = (byte) 1;
        fieldsStatus[5][4] = (byte) 1;
        fieldsStatus[2][5] = (byte) 1;
        fieldsStatus[3][5] = (byte) 1;

        CheckWin check = new CheckWin.Builder()
                .northLine(north)
                .southLine(south)
                .eastLine(east)
                .westLine(west)
                .fieldsStatus(fieldsStatus)
                .size(5)
                .build();

        Assert.assertFalse(check.checkOverallWin());
    }


}

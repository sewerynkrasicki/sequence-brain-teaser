package logic;

public class CheckWin {
    int longestSequenceBlack, longestSequenceWhite;
    int x = 0, counter = 0;
    boolean topSequenceBlack = true, bottomSequenceWhite = true;
    boolean sideSequenceBlack = true, sideSequenceWhite = true;
    int[] northLine, southLine, eastLine, westLine;
    byte[][] fieldsStatus;

    //PAMIETAC BY UŻYĆ BUDOWNICZEGO!!!!!!
    public CheckWin(int[] northLine, int[] southLine, int[] eastLine,
                    int[] westLine, byte[][] fieldsStatus)
    {
        this.northLine = northLine;
        this.southLine = southLine;
        this.eastLine = eastLine;
        this.westLine = westLine;
        this.fieldsStatus = fieldsStatus;
    }

    public boolean checkOverallWin()
    {
        return checkWinBlackTop()&&checkWinBlackSide()&&checkWinWhiteBottom()&&checkWinWhiteSide();
    }


    //Check top sequence of black boxes
    public boolean checkWinBlackTop() {
        while (x < 10) {
            longestSequenceBlack = northLine[x];
            for (int i = 1; i <= 10; i++) {

                if (fieldsStatus[i][x + 1] == (byte) 1) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > longestSequenceBlack) {
                    topSequenceBlack = false;
                    break;
                } else {
                    topSequenceBlack = true;
                }
            }
            if (!topSequenceBlack)
                break;
            counter = 0;
            x++;
        }
        return topSequenceBlack;
    }

    //Check side sequence of black boxes
    public boolean checkWinBlackSide() {
        x = 0;
        counter = 0;
        while (x < 10) {
            longestSequenceBlack = westLine[x];
            for (int j = 1; j <= 10; j++) {

                if (fieldsStatus[x + 1][j] == (byte) 1) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > longestSequenceBlack) {
                    sideSequenceBlack = false;
                    break;
                } else {
                    sideSequenceBlack = true;
                }
            }
            if (!sideSequenceBlack)
                break;
            counter = 0;
            x++;
        }
        return sideSequenceBlack;
    }

    //Check bottom sequence of white boxes
    public boolean checkWinWhiteBottom() {
        x = 0;
        counter = 0;

        while (x < 10) {
            longestSequenceWhite = southLine[x];
            for (int j = 1; j <= 10; j++) {

                if (fieldsStatus[j][x + 1] == (byte) 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > longestSequenceWhite) {
                    bottomSequenceWhite = false;
                    break;
                } else {
                    bottomSequenceWhite = true;
                }
            }
            if (!bottomSequenceWhite)
                break;
            counter = 0;
            x++;
        }
        return bottomSequenceWhite;
    }

    //Check side sequence of white boxes
    public boolean checkWinWhiteSide() {
        x = 0;
        counter = 0;
        while (x < 10) {
            longestSequenceWhite = eastLine[x];
            for (int j = 1; j < 10; j++) {

                if (fieldsStatus[x + 1][j] == (byte) 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > longestSequenceWhite) {
                    sideSequenceWhite = false;
                    break;
                } else {
                    sideSequenceWhite = true;
                }
            }
            if (!sideSequenceWhite)
                break;
            counter = 0;
            x++;
        }
        return sideSequenceWhite;
    }


}

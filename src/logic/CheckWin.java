package logic;

public class CheckWin {
    private int longestSequenceBlack, longestSequenceWhite;
    private int x = 0, counter = 0;
    private boolean topSequenceBlack = true, bottomSequenceWhite = true;
    private boolean sideSequenceBlack = true, sideSequenceWhite = true;
    private int[] northLine, southLine, eastLine, westLine;
    private byte[][] fieldsStatus;
    private int size;

    //BUILDER DESIGN PATTERN
    public static final class Builder {
        private int[] northLine, southLine, eastLine, westLine;
        private byte[][] fieldsStatus;
        private int size;

        public Builder northLine(int[] northLine) {
            this.northLine = northLine;
            return this;
        }

        public Builder southLine(int[] southLine) {
            this.southLine = southLine;
            return this;
        }

        public Builder eastLine(int[] eastLine) {
            this.eastLine = eastLine;
            return this;
        }

        public Builder westLine(int[] westLine) {
            this.westLine = westLine;
            return this;
        }

        public Builder fieldsStatus(byte[][] fieldsStatus) {
            this.fieldsStatus = fieldsStatus;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public CheckWin build() {
            CheckWin checkWin = new CheckWin();
            checkWin.northLine = this.northLine;
            checkWin.southLine = this.southLine;
            checkWin.westLine = this.westLine;
            checkWin.eastLine = this.eastLine;
            checkWin.fieldsStatus = this.fieldsStatus;
            checkWin.size = this.size;
            return checkWin;
        }
    }

    //Checks win
    public boolean checkOverallWin() {
        return checkWinBlackTop() && checkWinBlackSide() && checkWinWhiteBottom() && checkWinWhiteSide();
    }


    //Checks top sequence of black boxes
    public boolean checkWinBlackTop() {
        x = 0;
        counter = 0;
        while (x < size) {
            longestSequenceBlack = northLine[x];
            for (int i = 1; i <= size; i++) {

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

    //Checks side sequence of black boxes
    public boolean checkWinBlackSide() {
        x = 0;
        counter = 0;
        while (x < size) {
            longestSequenceBlack = westLine[x];
            for (int j = 1; j <= size; j++) {

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

    //Checks bottom sequence of white boxes
    public boolean checkWinWhiteBottom() {
        x = 0;
        counter = 0;

        while (x < size) {
            longestSequenceWhite = southLine[x];
            for (int j = 1; j <= size; j++) {

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

    //Checks side sequence of white boxes
    public boolean checkWinWhiteSide() {
        x = 0;
        counter = 0;
        while (x < size) {
            longestSequenceWhite = eastLine[x];
            for (int j = 1; j < size; j++) {

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

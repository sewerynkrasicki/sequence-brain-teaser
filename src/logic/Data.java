package logic;

import java.io.Serializable;

public class Data implements Serializable {

    private byte[][] fieldStatus;
    private int size;
    private int[] northLine, southLine, eastLine, westLine;

    //BUILDER DESIGN PATTERN
    public static final class Builder {
        private int[] northLine, southLine, eastLine, westLine;
        private byte[][] fieldStatus;
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

        public Builder fieldStatus(byte[][] fieldStatus) {
            this.fieldStatus = fieldStatus;
            return this;
        }

        public Builder size(int size)
        {
            this.size = size;
            return this;
        }

        public Data build()
        {
            Data data = new Data();
            data.northLine = this.northLine;
            data.southLine = this.southLine;
            data.westLine = this.westLine;
            data.eastLine = this.eastLine;
            data.fieldStatus = this.fieldStatus;
            data.size = this.size;
            return data;
        }
    }

    //getters
    public byte[][] getFieldStatus() {
        return fieldStatus;
    }

    public int getSize() {
        return size;
    }

    public int[] getNorthLine() {
        return northLine;
    }

    public int[] getSouthLine() {
        return southLine;
    }

    public int[] getEastLine() {
        return eastLine;
    }

    public int[] getWestLine() {
        return westLine;
    }


}

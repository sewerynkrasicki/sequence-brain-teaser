package logic;

import java.io.Serializable;

public class Data implements Serializable {

    private byte[][] fieldStatus;
    private int size;
    private int[] northLine, southLine, eastLine, westLine;

    public Data(byte[][] fieldStatus, int size, int[] northLine,
                int[] southLine, int[] eastLine, int[] westLine) {
        this.fieldStatus = fieldStatus;
        this.size = size;
        this.northLine = northLine;
        this.southLine = southLine;
        this.westLine = westLine;
        this.eastLine = eastLine;
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

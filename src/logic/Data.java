package logic;

import java.io.Serializable;

public class Data implements Serializable {

    private byte[][] fieldStatus;

    public Data(byte[][] fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public byte[][] getFieldStatus() {
        return fieldStatus;
    }

}

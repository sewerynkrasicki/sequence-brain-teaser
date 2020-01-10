package logic;

import java.io.Serializable;
import java.util.Stack;

public class History implements Serializable {
    private Stack<Data> history;
    private Stack<Data> historyTemp;

    public History() {
        history = new Stack<>();
        historyTemp = new Stack<>();
    }

    public void addData(Data data) {
        if (data != null) {
            history.add(data);
            historyTemp.clear();
        } else throw new NullPointerException();
    }

    public void addDataWithoutClearTemp(Data data) {
        if (data != null) {
            history.add(data);
        } else throw new NullPointerException();
    }

    public Data getPreviousData(Data data) {
        if (data != null) {
            addNextData(data);
            return history.pop();
        } else return history.pop();
    }

    public Data checkData()
    {
        return history.peek();
    }

    public Data getNextData(Data data) {
        addDataWithoutClearTemp(data);
        return historyTemp.pop();
    }

    public void addNextData(Data data) {
        if (data != null) {
            historyTemp.add(data);
        } else throw new NullPointerException();
    }

    public void clearHistory() {
        history.clear();
        historyTemp.clear();
        ;
    }

    public boolean isNextPossible() {
        return historyTemp.size() > 0;
    }

    public boolean isPreviousPossible() {
        return history.size() > 0;
    }
}
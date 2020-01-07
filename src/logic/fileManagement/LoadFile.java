package logic.fileManagement;

import logic.History;
import logic.fileManagement.ILoad;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFile implements ILoad {
    @Override
    public History Load(String file) throws IOException, ClassNotFoundException {
        History history;
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        history = (History)ois.readObject();
        fin.close();
        ois.close();
        return  history;
    }
}

package logic.fileManagement;

import logic.History;
import logic.fileManagement.ISave;

import java.io.*;

public class SaveFile implements ISave {

    @Override
    public void Save(History history, String file) throws IOException {
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(history);
        fout.close();
        oos.close();
    }
}

package logic.fileManagement;

import logic.History;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ISave {
    public void Save(History history, String file) throws IOException;
}

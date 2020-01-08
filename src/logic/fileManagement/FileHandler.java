package logic.fileManagement;

import logic.History;

import java.io.IOException;

public class FileHandler implements ISave, ILoad {
    private ILoad load;
    private ISave save;

    public FileHandler() {
        this.load = new LoadFile();
        this.save = new SaveFile();
    }

    @Override
    public History Load(String file) throws IOException, ClassNotFoundException {
        return load.Load(file);
    }

    @Override
    public void Save(History history, String file) throws IOException {
        save.Save(history, file);
    }
}

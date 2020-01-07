package logic.fileManagement;

import logic.History;

import java.io.IOException;

public interface ILoad {
    public History Load(String file) throws IOException, ClassNotFoundException;
}

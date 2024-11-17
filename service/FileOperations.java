package service;

import java.io.IOException;
import model.FamilyTree;

public interface FileOperations<T> {
    void saveToFile(FamilyTree<T> familyTree, String fileName) throws IOException;

    FamilyTree<T> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}



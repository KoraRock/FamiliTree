package service;

import java.io.IOException;
import model.FamilyTree;
import model.Person;

public interface FileOperations<T> {
    void saveToFile(FamilyTree<Person> familyTree, String fileName) throws IOException;

    FamilyTree<Person> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}



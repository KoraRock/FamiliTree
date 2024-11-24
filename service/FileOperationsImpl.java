package service;

import java.io.*;
import model.FamilyTree;
import model.Person;

public class FileOperationsImpl<T> implements FileOperations<T> {

    @Override
    public void saveToFile(FamilyTree<Person> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<Person> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<Person>) ois.readObject();
        }
    }
}

package presenter;

import java.io.IOException;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import view.TreeView;


public class TreePresenter {
    private FamilyTree<Person> familyTree;
    private TreeView view;
    private FileOperations<Person> fileOperations;

    public TreePresenter(FamilyTree<Person> familyTree, TreeView view, FileOperations<Person> fileOperations) {
        this.familyTree = familyTree;
        this.view = view;
        this.fileOperations = fileOperations;
        this.view.setPresenter(this);
    }

    public void showAllPerson() {
        view.displayPersons(familyTree.getMembers());
    }

    public void addPerson(String name, int birthYear) {
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        view.displayMessage("Вы добавили: " + name);
    }

    public void sortPeopleByName() {
        familyTree.sortByName();
        view.displayMessage("Произведена сортировка по имени: ");
        showAllPerson();
    }

    public void sortPeopleByBirthYear() {
        familyTree.sortByBirthYear();
        view.displayMessage("Произведена сортировка по году рождения: ");
        showAllPerson();
    }

    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            view.displayMessage("Семейное древо сохранено в " + fileName);            
        } catch (IOException e) {
            view.displayMessage("Ошибка сохранения: " + e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            view.displayMessage("Семейное древо считано из " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Ошибка считывания: " + e.getMessage());
        }
    }
    public void handleUserInput() {
        boolean stopper = true;
        while (stopper) {
            
            System.out.println("Введите команду (add, list, sortByName, sortByBirthYear, save, load, exit): ");
            String command = view.getUserInput();

            switch (command) {

                case "add" -> {
                    view.displayMessage("Введите имя: ");
                    String name = view.getUserInput();
                    view.displayMessage("Введите год рождения: ");
                    int birthYear = Integer.parseInt(view.getUserInput());
                    
                    addPerson(name, birthYear);
                }

                case "list" -> showAllPerson();

                case "sortByName" -> sortPeopleByName();
                    
                case "sortByBirthYear" -> sortPeopleByBirthYear();
                   
                case "save" -> {
                    view.displayMessage("Введите имя файла: ");
                    saveTree(view.getUserInput());
                }

                case "load" -> {
                    view.displayMessage("Введите имя файла: ");
                    loadTree(view.getUserInput());
                }
                
                case "exit" -> {
                    view.displayMessage("До новой встречи :)");
                    stopper = false;
                }
                
                default -> view.displayMessage("Неизвестная команда");
            }
        }
    }
}

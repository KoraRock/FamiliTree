package presenter;

import java.io.IOException;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import view.InputView;
import view.MessageView;
import view.PersonView;


public class TreePresenter {
    private FamilyTree<Person> familyTree;
    private MessageView messageView;
    private PersonView personView;
    private InputView inputView;
    private FileOperations<Person> fileOperations;

    public TreePresenter(FamilyTree<Person> familyTree, MessageView messageView, PersonView personView, 
    InputView inputView, FileOperations<Person> fileOperations) {
        this.familyTree = familyTree;
        this.messageView = messageView;
        this.personView = personView;
        this.inputView = inputView;
        this.fileOperations = fileOperations;
    }

    public void showAllPerson() {
        personView.displayPersons(familyTree.getMembers());
    }

    public void addPerson(String name, int birthYear) {
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        messageView.displayMessage("Вы добавили: " + name);
    }

    public void sortPeopleByName() {
        familyTree.sortByName();
        messageView.displayMessage("Произведена сортировка по имени: ");
        showAllPerson();
    }

    public void sortPeopleByBirthYear() {
        familyTree.sortByBirthYear();
        messageView.displayMessage("Произведена сортировка по году рождения: ");
        showAllPerson();
    }

    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            messageView.displayMessage("Семейное древо сохранено в " + fileName);            
        } catch (IOException e) {
            messageView.displayMessage("Ошибка сохранения: " + e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            messageView.displayMessage("Семейное древо считано из " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            messageView.displayMessage("Ошибка считывания: " + e.getMessage());
        }
    }
    public void handleCommand(String command) {
        switch (command) {

            case "1" -> { // Добавляем нового человека
                messageView.displayMessage("Введите имя: ");
                String name = inputView.getUserInput();
                messageView.displayMessage("Введите год рождения: ");
                int birthYear = Integer.parseInt(inputView.getUserInput());    
                addPerson(name, birthYear);
            }

            case "2" -> showAllPerson(); // Выводим список добавленных людей

            case "3" -> sortPeopleByName(); // Сортировка по имени
                    
            case "4" -> sortPeopleByBirthYear(); // Сортировка по году рождения
                   
            case "5" -> { // Сохраняем в файл
                messageView.displayMessage("Введите имя файла: ");
                saveTree(inputView.getUserInput());
            }

            case "6" -> { // Считываем из файла
                messageView.displayMessage("Введите имя файла: ");
                loadTree(inputView.getUserInput());
            }
                
            case "7" -> { // выход
                messageView.displayMessage("До новой встречи :)");
                System.exit(0);
            }
                
            default -> messageView.displayMessage("Неизвестная команда, попробуйте снова."); // если ввели что-то неизвестное
        }
    }
}

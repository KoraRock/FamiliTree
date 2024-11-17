package main;

import java.io.IOException;
import java.util.Scanner;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;


public class CommandManager {
    private FamilyTree<Person> familyTree;
    private Scanner scanner;

    public CommandManager (FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean stopper = true;
        while (stopper) {
            System.out.println("Введите команду (add, list, sortByName, sortByBirthYear, save, load, exit): ");
            String command = scanner.nextLine();
            FileOperations fileOps = new FileOperationsImpl();

            switch (command) {

                case "add" -> addPerson();

                case "list" -> listPeople();

                case "sortByName" -> {
                    familyTree.sortByName();
                    listPeople();
                }

                case "sortByBirthYear" -> {
                    familyTree.sortByBirthYear();
                    listPeople();
                }

                case "save" -> {
                    System.out.println("Введите название файла с указанием расширения, в который хотите сохранить данные: ");
                    String nameFile = scanner.nextLine();
                    
                    try {
                        fileOps.saveToFile(familyTree, nameFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                case "load" -> {
                    familyTree = null;
                    System.out.println("Введите название файла с указанием расширения, из которого хотите считать данные: ");
                    String nameFile = scanner.nextLine();

                    try {
                        familyTree = fileOps.loadFromFile(nameFile);
                        System.out.println("\nFamili tree loaded from file.");
                        listPeople();
                    } catch (IOException| ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                
                case "exit" -> {
                    System.out.println("До новой встречи :)");
                    stopper = false;
                }
                
                default -> {
                    System.out.println("Неизвестная команда");
                }
            }
        }
    }

    private void addPerson() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения: ");
        int birthYear = Integer.parseInt(scanner.nextLine());

        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        System.out.println("Вы добавили человека в дерево. ");
    }

    private void listPeople() {
        for (Person person : familyTree) {
           System.out.println(person.getName() + ", родился в " + person.getBirthYear()); 
        }
    }
}

package model;

// класс семейного древа
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private static final long serialVersionUID = 1L;    
    private List<T> members = new ArrayList<>();

    public void addMember(T person) {
        this.members.add(person);
    }

    // public List<Person> getChildren(Person parent) {
    //     return parent.getChildren();
    // }

    // public Person findPersonByName (String name) {
    //     for(T person : members) {
    //         if(person.getName().equals(name)){
    //             return (Person) person;
    //         }
    //     }
    //     return null;
    // }

    public void sortByName() {
        members.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthYear() {
        members.sort(Comparator.comparingInt(Person::getBirthYear));
    }

    public List<Person> getMembers() {
        return new ArrayList<>(members);
    }

}

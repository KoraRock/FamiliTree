package model;

// Класс людей
import java.io.*;


public class Person  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int birthYear;
    // private Person mother;
    // private Person father;
    // private List<Person> children;
    
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        // this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // public Person getMother() {
    //     return mother;
    // }

    // public void setMother(Person mother) {
    //     this.mother = mother;
    // }

    // public Person getFather() {
    //     return father;
    // }

    // public void setFather(Person father) {
    //     this.father = father;
    // }

    // public void addChild(Person child) {
    //     this.children.add(child);
    // }

    // public List<Person> getChildren() {
    //     return children;
    // }


}

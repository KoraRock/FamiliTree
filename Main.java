import java.util.ArrayList;
import java.util.List;

// Класс людей  
class Person {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;
    
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
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

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

}


// класс семейного древа
class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

    public Person findPersonByName (String name) {
        for(Person person : people) {
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }
}

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person ivan = new Person("Ivan", 1960);
        Person anna = new Person("Anna", 1961);
        Person egor = new Person("Egor", 1975);
        Person eva = new Person("Eva", 1977);

        egor.setMother(anna);
        egor.setFather(ivan);
        eva.setFather(ivan);
        eva.setMother(anna);
        ivan.addChild(eva);
        ivan.addChild(egor);
        anna.addChild(eva);
        anna.addChild(egor);

        familyTree.addPerson(ivan);
        familyTree.addPerson(anna);
        familyTree.addPerson(egor);
        familyTree.addPerson(eva);

        List<Person> annasChildren = familyTree.getChildren(anna);
        for(Person child:annasChildren){
            System.out.println("Anna's child: "+child.getName());
        }
        
    }
}
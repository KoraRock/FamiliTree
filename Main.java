import java.io.IOException;

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

// // first Home Work:
        // List<Person> annasChildren = familyTree.getChildren(anna);
        // for(Person child:annasChildren){
        //     System.out.println("Anna's child: "+child.getName());
        // }

// second Home Work: 
        FileOperations fileOps = new FileOperationsImpl();

        try {
            fileOps.saveToFile(familyTree, "familiTree.dat");
            System.out.println("Famili tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree loadedFamilyTree = null;

        try {
            loadedFamilyTree = fileOps.loadFromFile("familiTree.dat");
            System.out.println("Famili tree loaded from file.");
        } catch (IOException| ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(loadedFamilyTree!=null) {
            for(Person person:loadedFamilyTree.getPeople()){
                System.out.println("Loaded person: " + person.getName() + ", born in " + person.getBirthYear());
            }
        }
 

        
    }
}
package view;

import java.util.List;
import model.Person;
import presenter.TreePresenter;


public interface TreeView {
    void displayMessage(String message);
    void displayPersons(List<Person> persons);
    String getUserInput();
    void setPresenter(TreePresenter presenter);
}

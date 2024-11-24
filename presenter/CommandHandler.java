package presenter;

import view.ConsoleTreeView;

public class CommandHandler {
    private TreePresenter presenter;
    private ConsoleTreeView view;

    public CommandHandler(TreePresenter presenter, ConsoleTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    public void handleUserInput() {
        while (true) { 
            view.displayMessage("Введите номер команды (1 - добавить нового человека, 2 - показать список добавленных людей, " + 
            "3 - отсортировать по имени, 4 - отсортировать по году рождения, 5 - сохранить список в файл, " +
            "6 - считать список из файла, 7 - выйти): ");

            String command = view.getUserInput();
            presenter.handleCommand(command);
        }
    }

}

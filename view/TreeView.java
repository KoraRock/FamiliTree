package view;

import presenter.TreePresenter;


public interface TreeView extends MessageView, PersonView, InputView {
    void setPresenter(TreePresenter presenter);
}

package controller;

public class cmdRedo implements ICommand {
    @Override
    public void run(){cmdHistory.redo();}
}

package controller;

public class cmdUndo implements ICommand{
    @Override
    public void run(){ cmdHistory.undo();}

}

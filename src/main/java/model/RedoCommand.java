package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class RedoCommand implements ICommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> cmdUndo,cmdRedo;
  

    public RedoCommand(List<Shape> cmdUndo, List<Shape> cmdRedo, ShapeList shapeList){
        this.cmdUndo = cmdUndo;
        this.cmdRedo = cmdRedo;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        if(!shapeList.listEmpty()||!cmdRedo.isEmpty()){

            Shape undo = cmdRedo.get(cmdRedo.size()-1);
            cmdUndo.clear();
            cmdUndo.add(undo);
            shapeList.addShape(undo);
            shapeList.repainter();
            shapeList.updater();
            CommandHistory.add(this);
        }else{
            return;
        }

        redo();


    }

    @Override
    public void undo() {
        CommandHistory.undo();
    }

    @Override
    public void redo() {
        CommandHistory.redo();
    }
}

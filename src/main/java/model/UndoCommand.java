package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class UndoCommand implements ICommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> cmdUndo,cmdRedo;


    public UndoCommand(List<Shape> cmdUndo, List<Shape> cmdRedo, ShapeList shapeList){
        this.cmdUndo = cmdUndo;
        this.cmdRedo = cmdRedo;
        this.shapeList = shapeList;

    }

    @Override
    public void run() {
        

        if(!shapeList.listEmpty()){
            Shape redo = shapeList.masterShapeList.get(shapeList.index()); 
            cmdRedo.clear();
            cmdRedo.add(redo);
            shapeList.masterShapeList.remove(shapeList.recentIndex(redo));
            shapeList.repainter();
            shapeList.updater();


            CommandHistory.add(this);
        }else{
            return;
        }
        undo();



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



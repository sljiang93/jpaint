package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class UndoCommand implements ICommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public UndoCommand(ShapeList shapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo){
        this.shapeList = shapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;

    }

    @Override
    public void run() {
        undo();

        if(!shapeList.masterShapeList.isEmpty() || !commandHistoryRedo.isEmpty()){
        
            int shapeRedoIndex = shapeList.masterShapeList.size()-1;
            Shape shapeRedo = shapeList.masterShapeList.get(shapeRedoIndex);

            if(commandHistoryRedo.isEmpty()){
                
                commandHistoryRedo.add(shapeRedo);
            } else{
                commandHistoryRedo.clear();
                commandHistoryRedo.add(shapeRedo);
            }

            shapeList.masterShapeList.remove(shapeList.masterShapeList.size()-1);
            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.masterShapeList);


            CommandHistory.add(this);
        }else{return;}



    }

    @Override
    public void undo() { CommandHistory.undo(); }

    @Override
    public void redo() { CommandHistory.redo();}

}

package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class RedoCommand implements ICommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public RedoCommand(ShapeList shapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo){
        this.shapeList = shapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
    }

    @Override
    public void run() {
        redo();

        if(!shapeList.masterShapeList.isEmpty() || !commandHistoryRedo.isEmpty()){
            

        
            int UndoIndex = commandHistoryRedo.size()-1;
            Shape shapeUndo = commandHistoryRedo.get(UndoIndex);

            if(commandHistoryUndo.isEmpty()){
                
                commandHistoryUndo.add(shapeUndo);
            } else{
                commandHistoryUndo.clear();
                commandHistoryUndo.add(shapeUndo);
            }

        
            shapeList.masterShapeList.add(shapeUndo);

            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.masterShapeList);

            CommandHistory.add(this);
        }else{return;}


    }

    @Override
    public void undo() { CommandHistory.undo();}

    @Override
    public void redo() { CommandHistory.redo();}
}

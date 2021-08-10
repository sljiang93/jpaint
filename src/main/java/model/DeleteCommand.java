package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

import model.CreateShapeCommand;
import model.interfaces.IApplicationState;



public class DeleteCommand implements ICommand,IUndoable{

    public Shape deleteShape;
    public List<Shape> deleted = new ArrayList<Shape>();
    public ShapeList shapeList;
    public IApplicationState appState;
    public final int listSize;



    public void delete(){
        if (!deleted.isEmpty()){

            shapeList.masterShapeList.remove(listSize-1);

        }else{return;}
    }

    public DeleteCommand (IApplicationState appState, ShapeList shapeList){
        this.appState=appState;
        this.shapeList=shapeList;
        this.listSize=shapeList.masterShapeList.size();
        deleteShape = shapeList.masterShapeList.get(listSize-1);
    }


    @Override
    public void run() {
        delete();
        
        CommandHistory.add(this);
        // TODO Auto-generated method stub
        
    }

    @Override
    public void undo() {
        shapeList.masterShapeList.add(deleteShape);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.undo();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void redo() {
        delete();
        // TODO Auto-generated method stub
        
    }
    
}

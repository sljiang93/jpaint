package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

import model.CreateShape;
import model.interfaces.IApplicationState;



public class DeleteCommand implements ICommand,IUndoable{

    public Shape deleteShape;
    public List<Shape> deleted = new ArrayList<Shape>();
    public ShapeList shapeList;



    public DeleteCommand (ShapeList shapeList){
        this.shapeList=shapeList;
    }

    @Override
    public void undo() {
        CommandHistory.undo();
        shapeList.addShape(shapeList.selectedShapeList.get(shapeList.getSize()-1));
        shapeList.repainter();
        shapeList.updater();
        //shapeList.drawUpdate();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void redo() {
        run();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        shapeList.selectedShapeList.remove(shapeList.getSize()-1);
        shapeList.repainter();
        shapeList.updater();
        CommandHistory.add(this);
        //shapeMaker.shapeList.masterShapeList.remove(shapeMaker.recentIndex(shape));

        // TODO Auto-generated method stub
        
    }
}



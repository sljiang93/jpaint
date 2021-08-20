package model;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import java.util.ArrayList;
import java.util.List;



public class DeleteCommand implements ICommand,IUndoable{

    public List<Shape> deleted = new ArrayList<Shape>();
    public ShapeList shapeList;



    public DeleteCommand (ShapeList shapeList){
        this.shapeList=shapeList;
    }

    @Override
    public void undo() {
        CommandHistory.undo();
        shapeList.addShape(shapeList.selectedShapeList.get(shapeList.index()));
        shapeList.repainter();
        shapeList.updater();


        
    }

    @Override
    public void redo() {
        run();

        
    }

    @Override
    public void run() {
        shapeList.selectedShapeList.remove(shapeList.index());
        shapeList.repainter();
        shapeList.updater();
        CommandHistory.add(this);
        //shapeMaker.shapeList.masterShapeList.remove(shapeMaker.recentIndex(shape));

        
    }
}



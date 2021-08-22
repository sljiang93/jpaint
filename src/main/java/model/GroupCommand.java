package model;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.ShapeList;
import model.ShapeMaker;
import java.util.List;
import java.util.ArrayList;


public class GroupCommand implements ICommand, IUndoable{
    public Shape shape;
    public ShapeMaker shapeMaker;
    public List<Shape> groupList,selectedShapeList;
    public ShapeList shapeList;

    public GroupCommand (List<Shape>selectedShapeList,List<Shape>groupList,ShapeList shapeList){
        this.selectedShapeList=selectedShapeList;
        this.groupList=groupList;
        this.shapeList=shapeList;
    }




    @Override
    public void undo() {
        if (groupList!=null){
            shapeList.groupRemove(shape);
            CommandHistory.undo();
        }

        
    }

    @Override
    public void redo() {
        if (groupList!=null){
            shapeList.groupAdd(shape);
            CommandHistory.redo();
        }

        
    }

    @Override
    public void run() {
        int numShapes = shapeList.groupSize();
        for (Shape shape: shapeList.getSelectedShapeList()){
            if(!shapeList.groupContains()){
                
                shapeList.groupAdd(shape);
                groupList.add(shape);

                System.out.println(numShapes);
               
            }
            else{
                return;
                
            }
        }
        
        
        
    }
    
}

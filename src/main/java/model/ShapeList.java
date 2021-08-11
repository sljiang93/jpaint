package model;
import model.interfaces.IApplicationState;
import java.util.List;
import java.util.ArrayList;




public class ShapeList{

    public DrawShapeStrategy drawShapeHandler;
    public Shape shape;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;
    public List<Shape> selectedShapeList;
    public List<Shape> masterShapeList;
    public List<Shape> groupList;
    IApplicationState applicationState;
    public ShapeList(DrawShapeStrategy drawShapeHandler, List<Shape> masterShapeList,List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo, List<Shape> selectedShapeList, List<Shape> groupList)
    {
        this.drawShapeHandler = drawShapeHandler;
        this.masterShapeList = masterShapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
        this.selectedShapeList = selectedShapeList;
        this.groupList=groupList;
    }

    public void addShape(Shape shape){
        masterShapeList.add(shape);
    }

    public void removeShape (Shape shape){
        masterShapeList.remove(shape);
    }

    public List<Shape> getShapeList(){
        return masterShapeList;
    }

    public int getSize(){
        return masterShapeList.size();
    }

    public List<Shape> getSelectList(){
        return selectedShapeList;
    }
    public int getSelectSize(){
        return selectedShapeList.size();
    }

    public void selectAdd(Shape shape){
        selectedShapeList.add(shape);
    }

    public void selectRemove (Shape shape){
        selectedShapeList.remove(shape);
    }

    public void groupAdd (Shape shape){
        groupList.add(shape);
    }

    public void groupRemove (Shape shape){
        groupList.remove(shape);
    }



}

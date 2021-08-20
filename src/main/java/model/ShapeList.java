package model;
import model.interfaces.IApplicationState;
import java.util.List;
import java.util.ArrayList;




public class ShapeList{

    public Shape shape;
    public List<Shape> commandHistoryUndo,commandHistoryRedo;
    public List<Shape> selectedShapeList;
    public List<Shape> masterShapeList;
    public List<Shape> groupList;
    public List<Shape> copyList;
    public DrawShapeStrategy drawShapeStrategy;
    IApplicationState applicationState;
    public ShapeList(DrawShapeStrategy drawShapeStrategy, List<Shape> masterShapeList,List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo, List<Shape> selectedShapeList, List<Shape> groupList, List<Shape> copyList)
    {
        this.drawShapeStrategy = drawShapeStrategy;
        this.masterShapeList = masterShapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
        this.selectedShapeList = selectedShapeList;
        this.groupList=groupList;
        this.copyList = copyList;
    }

    public void addShape(Shape shape){
        masterShapeList.add(shape);
    }

    public void removeShape (Shape shape){
        masterShapeList.remove(shape);
    }

    public boolean listEmpty (){
        return masterShapeList.isEmpty();
    }

    public int recentIndex (Shape shape){
        return masterShapeList.size()-1;
    }

    public List<Shape> getShapeList(){
        return masterShapeList;
    }

    public int getSize(){
        return masterShapeList.size();
    }
    public int index(){
        return masterShapeList.size()-1;
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

    public List<Shape> getGroupList(){
        return groupList;
    }

    public int groupSize(){
        return groupList.size();
    }

    public List<Shape> getCopyList(){
        return copyList;
    }
    public void copyAdd(Shape shape){
        this.copyList.add(shape);
    }
    public int copySize(){
        return copyList.size();
    }

    public void repainter(){
        drawShapeStrategy.paintCanvas.repaint();
    }

    public void updater(){
        drawShapeStrategy.update(masterShapeList);
    }

    public void drawUpdate(){
        this.drawShapeStrategy.update(masterShapeList);
    }



}

package model;
import model.interfaces.IApplicationState;
import java.util.List;
import java.util.ArrayList;




public class ShapeList{

    public DrawShapeHandler drawShapeHandler;
    public Shape shape;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;
    public List<Shape> selectedListShape;
    public List<Shape> masterShapeList;
    IApplicationState applicationState;
    public ShapeList(DrawShapeHandler drawShapeHandler, List<Shape> masterShapeList,List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo)
    {
        this.drawShapeHandler = drawShapeHandler;
        this.masterShapeList = masterShapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
        this.selectedListShape = selectedListShape;
    }

}

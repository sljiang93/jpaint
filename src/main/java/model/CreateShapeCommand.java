package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;



public class CreateShapeCommand implements ICommand,IUndoable {

    public ShapeMaker shapeMaker;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public Shape shape;
    public String clickType;

    public CreateShapeCommand(ShapeMaker shapeMaker, ShapeType shapeType, Point startPoint, Point endPoint, String clickType) {
        this.shapeMaker = shapeMaker;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.clickType = clickType;
    }

    @Override
    public void run() {
        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeMaker.appState.getActivePrimaryColor(),
                shapeMaker.appState.getActiveSecondaryColor(), shapeMaker.appState.getActiveShapeShadingType(), clickType);

        shapeMaker.shapeList.masterShapeList.add(shape);
        shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    public int toSize(){
        return shapeMaker.shapeList.masterShapeList.size();
    }

    @Override
    public void undo(){
        CommandHistory.undo();
    }

    @Override
    public void redo(){
        CommandHistory.redo();
    }
}





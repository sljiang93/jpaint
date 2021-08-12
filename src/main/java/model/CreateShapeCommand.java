package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;



public class CreateShapeCommand implements ICommand,IUndoable {

    public ShapeMaker shapeMaker;
    public ShapeType shapeType;
    public Point startPoint,endPoint;
    public Shape shape;

    public CreateShapeCommand(ShapeMaker shapeMaker, ShapeType shapeType, Point startPoint, Point endPoint/*, String clickType*/) {
        this.shapeMaker = shapeMaker;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run() {
        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeMaker.appState.getActivePrimaryColor(),
                shapeMaker.appState.getActiveSecondaryColor(), shapeMaker.appState.getActiveShapeShadingType(), null);

        shapeMaker.shapeList.masterShapeList.add(shape);
        shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    public int manageSize(){
        return shapeMaker.shapeList.masterShapeList.size();
    }

    @Override
    public void undo(){
        CommandHistory.undo();
        //shape.shapeList.removeShape(shape);
        
    }

    @Override
    public void redo(){
        CommandHistory.redo();
        //shape.shapeList.addShape(shape);
    }
}





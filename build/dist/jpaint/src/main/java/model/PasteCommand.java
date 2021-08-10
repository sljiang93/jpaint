package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import java.util.ArrayList;
import java.util.List;
import view.gui.PaintCanvas;

public class PasteCommand implements ICommand,IUndoable{

    public ShapeList shapeList;
    
    public List<Shape> copyList;

    public void paste(List<Shape> copyList){

        for(Shape shape: copyList){

            shape.startPoint.x = shape.startPoint.x+ 100;
            shape.startPoint.y = shape.startPoint.y+ 100;

            shape.endPoint.x = shape.endPoint.x+ 100;
            shape.endPoint.y = shape.endPoint.y+ 100;

            Shape dupliShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType, shape.clickType);

            shapeList.masterShapeList.add(dupliShape);
            CommandHistory.add(this);
        }


        
    }





    @Override
    public void run() {
        paste(copyList);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.add(this);
        // TODO Auto-generated method stub
        
    }

    @Override
    public void undo() {
        CommandHistory.undo();
        
        // TODO Auto-generated method stub
        
    }

    @Override
    public void redo() {
        run();
        // TODO Auto-generated method stub
        
    }

    
}

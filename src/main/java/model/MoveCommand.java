package model;

import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.interfaces.ICommand;
import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

public class MoveCommand implements ICommand, IUndoable {

    public ShapeType shapeType;
    public Point mousePressed;
    public Point mouseReleased;
    public ShapeMaker shapeMaker;
    public List<Shape> movedShapeList = new ArrayList<>();
    public int xs,ys,w,h,xe,ye;

    public int dX;
    public int dY;


    public MoveCommand(ShapeMaker shapeMaker, ShapeType shapeType, Point mousePressed, Point mouseReleased){
        this.shapeMaker = shapeMaker;
        this.shapeType = shapeType;
        this.mousePressed = mousePressed;
        this.mouseReleased = mouseReleased;

        dX= (mouseReleased.x - mousePressed.x);
        dY = (mouseReleased.y - mousePressed.y);
    }

    @Override
    public void run() {
        move(shapeMaker.shapeList.masterShapeList);
        pasteMoved(movedShapeList);
        //shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
        shapeMaker.shapeList.drawShapeHandler.paintCanvas.repaint();
        //shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
        
        CommandHistory.add(this);
    }

    private void move(List<Shape> masterShapeList) {

        for(Shape shape: masterShapeList) {
            xs = mousePressed.x;
            ys = mousePressed.y;
            xe = mouseReleased.x;
            ye = mouseReleased.y;

            if((xs>= shape.getXMin() && xs<=shape.getXMax() && ye>=shape.getYMin() && ye <=shape.getYMax()&&xe>= shape.getXMin() && xe<=shape.getXMax() && ys>=shape.getYMin() && ys <=shape.getYMax())){

                //int newStartPointX = (shape.startPoint.x)+dX;
                //int newStartPointY = (shape.startPoint.y)+dY;

                //int newEndPointX = (shape.endPoint.x)+dX;
                //int newEndPointY = (shape.endPoint.y)+dY;

                Point newStartPoint = new Point((shape.startPoint.x)+dX, (shape.startPoint.y)+dY);
                Point newEndPoint = new Point((shape.endPoint.x)+dX,(shape.endPoint.y)+dY);

                Shape movedShape = new Shape(shapeType, newStartPoint, newEndPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType,shape.appState);
                //shapeMaker.shapeList.commandHistoryUndo.add(shape);
                //shapeMaker.shapeList.commandHistoryRedo.add(movedShape);

                movedShapeList.add(shape);
                movedShapeList.add(movedShape);
                //movedShapeList.remove(shape);
                //shape.shapeList.addShape(movedShape);
                //CommandHistory.add(this);

            }
        }
    }

    private void pasteMoved(List<Shape> movedShapeList) {
        for (Shape shape : movedShapeList) {
            if (!shapeMaker.shapeList.masterShapeList.contains(shape)) {
                Shape movedShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType,shape.appState);
                shapeMaker.shapeList.masterShapeList.add(movedShape);
            }
            else{
                shapeMaker.shapeList.masterShapeList.remove(shape);
                
            }
        }
    }

    @Override
    public void undo() {
        if(shapeMaker.shapeList.masterShapeList.isEmpty()){
            System.out.println("no shapes left to remove");
        } else {
            System.out.println("masterShapeList size = "+ shapeMaker.shapeList.masterShapeList.size());
            shapeMaker.shapeList.masterShapeList.remove(shapeMaker.shapeList.masterShapeList.size()-1);
            pasteMoved(shapeMaker.shapeList.commandHistoryUndo);
            pasteMoved(shapeMaker.shapeList.commandHistoryRedo);

            System.out.println("masterShapeList size = "+ shapeMaker.shapeList.masterShapeList.size());
            shapeMaker.shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
        }

    }

    // bug in redo, pastes both the moved shape and the originally drawn shape on redo button. Can't get rid of both shapes in masterShapeList

    @Override
    public void redo() {
        run();
    }

}


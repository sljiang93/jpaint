package model;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.IUndoable;
import model.interfaces.ICommand;
import model.Shape;
import model.interfaces.IShape;
import java.awt.*;


public class MoveCommand implements ICommand, IUndoable{
    public Point startPoint, endPoint;
    public int dX, dY;
    public ShapeMaker shapeMaker;
    public ArrayList<Shape> movedList = new ArrayList<>();
    public ArrayList<Shape> beforeList = new ArrayList<>();
    public ArrayList<Shape> masterShapeList = new ArrayList<>();
    public Shape shape;
    public int xs,ys,w,h,xe,ye;



    public MoveCommand (ShapeMaker shapeMaker, Point startPoint, Point endPoint, Shape shape){
        this.shapeMaker=shapeMaker;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shape = shape;
        dX = (endPoint.x - startPoint.x);
        dY = (endPoint.y - startPoint.y);
    }

    @Override
    public void undo() {
        Point movedStart = new Point (shape.startPoint.x, shape.startPoint.y);
        Point movedEnd = new Point (shape.endPoint.x, shape.endPoint.y);
        Shape endShape = new Shape(shape.shapeType, movedStart, movedEnd, shape.primaryColor, shape.secondaryColor, shape.shadingType, shape.appState);
        shapeMaker.shapeList.masterShapeList.add(endShape);
        // TODO Auto-generated method stub
        
    }

    @Override
    public void redo() {
        run();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        xs = startPoint.x;
        ys = startPoint.y;
        xe = endPoint.x;
        ye = endPoint.y;

        for(Shape shape: movedList){
            if((xs>= shape.getXMin() && xs<=shape.getXMax() && ye>=shape.getYMin() && ye <=shape.getYMax()&&xe>= shape.getXMin() && xe<=shape.getXMax() && ys>=shape.getYMin() && ys <=shape.getYMax())){
        System.out.println("MOVE IN PROGRESS");
        Point movedStart = new Point (shape.startPoint.x + dX, shape.startPoint.y + dY);
        Point movedEnd = new Point (shape.endPoint.x + dX, shape.endPoint.y + dY);
        Shape endShape = new Shape(shape.shapeType, movedStart, movedEnd, shape.primaryColor, shape.secondaryColor, shape.shadingType, shape.appState);
        shapeMaker.shapeList.commandHistoryUndo.add(shape);
                shapeMaker.shapeList.commandHistoryRedo.add(endShape);

                movedList.add(shape);
                movedList.add(endShape);
                shapeMaker.shapeList.drawShapeHandler.paintCanvas.repaint();
                shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);
                shapeMaker.shapeList.masterShapeList.add(endShape);
                System.out.println("MOVE success");}

                




        // TODO Auto-generated method stub
        
    }

    
}}

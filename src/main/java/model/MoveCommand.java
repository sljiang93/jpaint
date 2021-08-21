package model;

import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.interfaces.ICommand;
import java.util.ArrayList;
import java.awt.*;
import java.util.List;

import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements ICommand, IUndoable {

    
    public Point moveStart,moveEnd;
    private Graphics2D graphics2d;
    public Shape shape;
    public Color color;
    public ShapeMaker shapeMaker;
    public ShapeType shapeType;
    public List<Shape> movedShapeList = new ArrayList<>();
    public List<Shape> whiteOutList = new ArrayList<>();
    public int xs,ys,w,h,xe,ye,dX,dY;

  


    public MoveCommand(ShapeMaker shapeMaker, Point moveStart, Point moveEnd,   ShapeType shapeType){
        this.shapeMaker = shapeMaker;
        this.moveStart = moveStart;
        this.moveEnd = moveEnd;
        this.shapeType = shapeType;

    }

    @Override
    public void run() {

        moveHelper(shapeMaker.master());
    }
 
    

    public void moveHelper(List<Shape> masterShapeList) {
        dX= (moveEnd.x - moveStart.x);
        dY = (moveEnd.y - moveStart.y);
        PaintCanvasBase paintCanvas = new PaintCanvas();

        for(Shape shape: masterShapeList) {
            xs = moveStart.x;
            ys = moveStart.y;
            xe = moveEnd.x;
            ye = moveEnd.y;

            if((xs>= shape.getXMin() && xs<=shape.getXMax() && ys>=shape.getYMin() && ys <=shape.getYMax())){

                Point startPoint = new Point((shape.startPoint.x), (shape.startPoint.y));
                Point endPoint = new Point((shape.endPoint.x), (shape.endPoint.y));



                Point movedStartPoint = new Point((shape.startPoint.x)+dX, (shape.startPoint.y)+dY);
                Point movedEndPoint = new Point((shape.endPoint.x)+dX,(shape.endPoint.y)+dY);

                Shape movedShape = new Shape(shapeType, movedStartPoint, movedEndPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType,shape.appState);
                Shape updater = new Shape(shapeType, startPoint,endPoint,ShapeColor.WHITE,ShapeColor.WHITE,shape.shadingType,shape.appState);

                
                shapeMaker.cmdUndo(shape);
                shapeMaker.cmdRedo(movedShape);
              

                shapeMaker.shapeList.addShape(updater);
                shapeMaker.shapeList.addShape(movedShape);
                shapeMaker.move(shape);
                shapeMaker.move(movedShape);
            

            }
        }
    

        for (Shape shape : movedShapeList) {
 
            if (shapeMaker.containShape(shape)) {
                shapeMaker.shapeList.removeShape(shape);
            }
            else{

                Shape moveShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType,shape.appState);
                shapeMaker.shapeList.addShape(moveShape);
                
                
            }
        }
        shapeMaker.drawUpdate();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        if(!shapeMaker.shapeList.masterShapeList.isEmpty()){
        
            
            shapeMaker.shapeList.masterShapeList.remove(shapeMaker.recentIndex(shape));
            shapeMaker.drawUpdate();

        }else{
            return;

    }


    }

    
    @Override
    public void redo() {
        run();
    }

}





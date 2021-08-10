package model;
import java.awt.*;
import java.util.List;

import model.interfaces.IApplicationState;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShapeStrategy;
import view.gui.PaintCanvas;



public class DrawShapeHandler implements IDrawShapeHandler {

    private IShapeStrategy shapeStrategy;
    private IApplicationState applicationState;
    public PaintCanvas paintCanvas;
    double dX,dY;

    public DrawShapeHandler(PaintCanvas paintCanvas, IShapeStrategy shapeStrategy){
        this.paintCanvas = paintCanvas;
        this.shapeStrategy = shapeStrategy;
    }

    public void update(List<Shape> masterShapeList) {
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: masterShapeList){



            switch(shape.shapeType){
                case RECTANGLE:
                    shapeStrategy = new RectangleStrategy(shape.primaryColor, shape.secondaryColor, shape, graphics);
                    break;
                case TRIANGLE:
                    shapeStrategy = new TriangleStrategy(shape.primaryColor, shape.secondaryColor, shape,graphics);
                    break;
                case ELLIPSE:
                    shapeStrategy = new EllipseStrategy(shape.primaryColor, shape.secondaryColor, shape, graphics);
                    break;



            }










            shapeStrategy.draw();
        }
    }

    @Override
    public void addX(double dX) {
        return;
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addY(double dY) {
        return;
        // TODO Auto-generated method stub
        
    }

    @Override
    public Point getAdjustedEnd() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point getAdjustedStart() {
        // TODO Auto-generated method stub
        return null;
    }
}

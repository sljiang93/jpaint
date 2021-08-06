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

    public DrawShapeHandler(PaintCanvas paintCanvas, IShapeStrategy shapeStrategy){
        this.paintCanvas = paintCanvas;
        this.shapeStrategy = shapeStrategy;
    }

    public void update(List<Shape> masterShapeList) {
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: masterShapeList){



            switch(shape.shapeType){
                case RECTANGLE:
                    shapeStrategy = new RectangleStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
                    break;
                case TRIANGLE:
                    shapeStrategy = new TriangleStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
                    break;
                case ELLIPSE:
                    shapeStrategy = new EllipseStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
                    break;



            }










            shapeStrategy.draw();
        }
    }
}

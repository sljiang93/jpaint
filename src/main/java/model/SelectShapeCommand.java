package model;
import model.interfaces.ICommand;
import model.interfaces.IDrawShapeHandler;
import controller.MouseClick;
import model.ShapeList;
import model.Shape;
import model.interfaces.IShapeStrategy;
import view.gui.PaintCanvas;
import model.CreateShapeCommand;
import java.awt.*;
import java.awt.Point;
import java.util.List;




public class SelectShapeCommand implements ICommand{

    public ShapeList shapeList;
    public Point startPoint;
    public Point endPoint;
    public PaintCanvas canvas;
    public int height, width;
    public int xMin, xMax, yMin, yMax;
    public Point boxStart,boxEnd;
    public ShapeFactory shapeFactory;
    public Shape shape;
    public static SelectShapeCommand box;
    public ShapeType shapeType;
    public String clickType;
    public IDrawShapeHandler selectedShape;



    public SelectShapeCommand (ShapeFactory shapeFactory,Point boxStart,Point boxEnd){
        this.shapeFactory = shapeFactory;
        this.boxStart=boxStart;
        this.boxEnd=boxEnd;
    }



    @Override
    public void run() {
        selectAdd(shapeFactory.shapeList.masterShapeList);
        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeFactory.appState.getActivePrimaryColor(),
                shapeFactory.appState.getActiveSecondaryColor(), shapeFactory.appState.getActiveShapeShadingType(), clickType);
        shapeFactory.shapeList.masterShapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);




        // TODO Auto-generated method stub

    }

    public IDrawShapeHandler getSeletectedShape(){
        return selectedShape;
    }

    public void selectAdd (List<Shape> masterShapeList){

        xMin = boxStart.x;
        yMax = boxEnd.y;

        for (Shape shape: masterShapeList){
            if (shape.containsPoint(xMin, yMax)){
                System.out.println("select success");

                shapeFactory.shapeList.masterShapeList.add(shape);
                //DrawShapeHandler.shapeStrategy.drawRect(xMin-1,yMax+1);

            }else{
                System.out.println("select fail");
            }
        }



    }

}

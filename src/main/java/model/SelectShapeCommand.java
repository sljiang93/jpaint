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

import java.util.EnumMap;
import java.awt.Graphics2D;




public class SelectShapeCommand implements ICommand{

    public ShapeList shapeList;
    public Point startPoint;
    public Point endPoint;
    public PaintCanvas canvas;
    public int height, width;
    public int xMin, xMax, yMin, yMax,xBox,yBox;
    public Point boxStart,boxEnd;
    public ShapeMaker shapeMaker;
    public Shape shape;
    public static SelectShapeCommand box;
    public ShapeType shapeType;
    public IDrawShapeHandler selectedShape;



    public SelectShapeCommand (ShapeMaker shapeMaker,Point boxStart,Point boxEnd){
        this.shapeMaker = shapeMaker;
        this.boxStart=boxStart;
        this.boxEnd=boxEnd;
    }



    @Override
    public void run() {
        selectAdd(shapeMaker.shapeList.masterShapeList);
        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeMaker.appState.getActivePrimaryColor(),
                shapeMaker.appState.getActiveSecondaryColor(), shapeMaker.appState.getActiveShapeShadingType()/*, clickType*/);
        shapeMaker.shapeList.masterShapeList.add(shape);
        shapeMaker.shapeList.drawShapeHandler.update(shapeMaker.shapeList.masterShapeList);




        // TODO Auto-generated method stub

    }

    public IDrawShapeHandler getSeletectedShape(){
        return selectedShape;
    }

    public void borderBox(Graphics2D graphics){

        graphics.setColor(Color.black);
        graphics.setStroke(new BasicStroke(4.0f));
        float alpha = 0.6f;
        graphics.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        graphics.setComposite(ac);

    }

    public void selectAdd (List<Shape> masterShapeList){

        xMin = startPoint.x;
        yMax = endPoint.y;
        xBox = boxStart.x;
        yBox = boxEnd.y;

        for (Shape shape: masterShapeList){
            if (xBox<=xMin&&yBox>=yMax){
                System.out.println("select success");
                

                shapeMaker.shapeList.masterShapeList.add(shape);
                masterShapeList.stream().forEach(System.out::println);
               
              
               

            }else{
                System.out.println("select fail");
                
            }
        }



    }

}

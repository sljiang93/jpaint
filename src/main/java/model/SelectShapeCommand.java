package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;
import java.util.List;

public class SelectShapeCommand implements ICommand {

    public ShapeMaker shapeMaker;
    public Point startPoint;
    public Point endPoint;
    public int xs,ys,w,h,xe,ye;
    public ShapeType shapeType;

    public SelectShapeCommand(ShapeMaker shapeMaker, Point startPoint, Point endPoint, ShapeType shapeType) {
        this.shapeMaker = shapeMaker;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = shapeType;
    }

    @Override
    public void run() {
        selectHelper(shapeMaker.master());
        //BorderDrawer.drawDash (ShapeList);
    }

    public void selectHelper(List<Shape> masterShapeList){
        xs = startPoint.x;
        ys = startPoint.y;
        xe = endPoint.x;
        ye = endPoint.y;
        

        for(Shape shape: masterShapeList){
            if((xs>= shape.getXMin() && xs<=shape.getXMax() && ye>=shape.getYMin() && ye <=shape.getYMax()&&xe>= shape.getXMin() && xe<=shape.getXMax() && ys>=shape.getYMin() && ys <=shape.getYMax())){
                shapeMaker.selectAdd(shape);
                //shapeMaker.groupList.add(shape);
                //shapeMaker.shapeList.getGroupList().contains(shape);
                System.out.println("Select shapes: " );
                System.out.println(shapeType);
            }
        }
       
        shapeMaker.drawUpdate();


    
    }

}


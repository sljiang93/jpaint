package model;

import java.awt.Point;
import model.persistence.ApplicationState;

public class Shape {

    public ShapeList shapeList;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public int height, width;
    public int xMin, xMax, yMin, yMax, middle;
    public ShapeColor primaryColor;
    public ShapeColor secondaryColor;
    public ShapeShadingType shadingType;
    public ApplicationState appState;



    public Shape(ShapeType shapeType, Point startPoint, Point endPoint, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, ApplicationState appState) {
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.appState = appState;

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);

        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);

        width = xMax-xMin;
        height = yMax-yMin;
        middle = (xMin)+((xMax-xMin)/2);
    }

    public void shapeStats(){
        this.shapeType = appState.getActiveShapeType();
		this.primaryColor = appState.getActivePrimaryColor();
		this.secondaryColor = appState.getActiveSecondaryColor();
		this.shadingType = appState.getActiveShapeShadingType();
    }


    public int getXMax(){ return xMax;}

    public int getXMin(){return xMin;}

    public int getYMax(){ return yMax;}

    public int getYMin(){return yMin;}

    public int getHeight(){ return height; }

    public int getWidth(){ return width; }

    public int getTriangleMidPoint(){ return middle;}

}


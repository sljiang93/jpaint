package model;
import java.awt.*;
import model.persistence.ApplicationState;
import java.lang.Math;

public class Shape {
    public int xMin, xMax, yMin, yMax;
    public ShapeList shapeList;
    public ShapeType shapeType;
    public Point startPoint,endPoint;
    public ShapeColor primaryColor,secondaryColor;
    public ShapeShadingType shadingType;
    public ApplicationState appState;



    public Shape(ShapeType shapeType, Point startPoint, Point endPoint, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, ApplicationState appState) {
 
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.appState = appState;
        this.shapeType = shapeType;

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);
        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);
        
    }

    public void shapeStats(){
        this.shapeType = appState.getActiveShapeType();
		this.primaryColor = appState.getActivePrimaryColor();
		this.secondaryColor = appState.getActiveSecondaryColor();
		this.shadingType = appState.getActiveShapeShadingType();
    }



 
    public int getWidth(){ return xMax - xMin;}

    public int getHeight(){ return yMax - yMin;}

    public int getXMin(){return xMin;}

    public int getXMax(){ return xMax;}

    public int getYMin(){return yMin;}

    public int getYMax(){ return yMax;}

    public int getMiddlePoint(){ return (xMax)-((xMax-xMin)/2);}


   

}


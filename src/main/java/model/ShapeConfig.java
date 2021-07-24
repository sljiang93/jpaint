package model;
import model.ShapeColor;
import model.ShapeType;
import view.gui.MouseClick;

import java.awt.*;

public class ShapeConfig {
    public ShapeColor Color1;
    public ShapeColor Color2;
    public Point startP;
    public Point endP;
    public ShapeShadingType shadingType;
    public ShapeType shapeType;
    public int w;
    public int h;

    public void primaryColor (ShapeColor Color1){
        this.Color1=Color1;
    }
    public void secondColor (ShapeColor Color2){
        this.Color1=Color2;
    }
    public void shapeType(ShapeType shapeType){
        this.shapeType=shapeType;
    }
    public void shadingType (ShapeShadingType shadingType){
        this.shadingType = shadingType;
    }

}

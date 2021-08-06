package model.interfaces;

import model.ShapeColor;

import java.awt.*;

public interface IShapeStrategy {
    Color EnumColorMap(ShapeColor shapeColor);
    void draw();
    //Boolean contains(Point startPoint);
}

package model.interfaces;

import model.Shape;

import java.util.List;
import java.awt.*;

public interface IDrawShapeHandler {
    void update(List<Shape> masterShapeList);
    void addX(double dX);
    void addY(double dY);
    Point getAdjustedEnd();
    Point getAdjustedStart();
}

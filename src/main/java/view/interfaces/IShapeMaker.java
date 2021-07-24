package view.interfaces;

import model.ShapeMaker.CreateShape;

import java.awt.*;

public interface IShapeMaker {
    public void setGraphics (Graphics2D graphics2d);
    public void draw (CreateShape shape, Graphics2D graphics2d);
}

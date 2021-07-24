package model.ShapeMaker;
import view.interfaces.IShapeMaker;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
public class RectangleStrat implements IShapeMaker {
    @Override
    public void setGraphics(Graphics2D graphics2d) {

    }

    @Override
    public void draw(CreateShape shape, Graphics2D graphics2d) {

    graphics2d.drawRect(shape.x,shape.y,shape.w,shape.h);
    graphics2d.fillRect(shape.x,shape.y,shape.w,shape.h);
    graphics2d.setColor(Color.WHITE);
    graphics2d.setStroke(new BasicStroke(5));
    graphics2d.setColor(shape.Color2);
    }

}

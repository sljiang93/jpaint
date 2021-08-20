package model;
import java.awt.*;
import model.interfaces.IShape;
import java.util.EnumMap;
import controller.MouseClick;



public class TriangleStrategy implements IShape {
    private ShapeColor primaryColor, secondaryColor;
    private Graphics2D graphics2d;
    private Shape shape;




    public TriangleStrategy(ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape, Graphics2D graphics2d) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.graphics2d = graphics2d;
    }


    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                int[] xF = {shape.getXMin(), shape.getMiddlePoint(), shape.getXMax()};
                int[] yF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryF = ColorMap(primaryColor);

                graphics2d.setColor(primaryF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillPolygon(xF, yF, 3);
                break;

            case OUTLINE:
                int[] xO = {shape.getXMin(), shape.getMiddlePoint(), shape.getXMax()};
                int[] yO = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryO = ColorMap(primaryColor);

                graphics2d.setColor(primaryO);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawPolygon(xO, yO, 3);
                break;

            case OUTLINE_AND_FILLED_IN:
                int[] xOF = {shape.getXMin(), shape.getMiddlePoint(), shape.getXMax()};
                int[] yOF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };
                Color primaryOF = ColorMap(primaryColor);
                graphics2d.setColor(primaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillPolygon(xOF, yOF, 3);

                Color secondaryOF = ColorMap(secondaryColor);
                graphics2d.setColor(secondaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawPolygon(xOF, yOF, 3);
                break;



        }

    }


    public Color ColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor, Color> color = new EnumMap<>(ShapeColor.class);
        ColorAdapter.getColor(shapeColor,color);
        return color.get(shapeColor);
    }


}

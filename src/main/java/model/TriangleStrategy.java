package model;

import model.interfaces.IShapeStrategy;
import controller.MouseClick;
import java.awt.*;
import java.util.EnumMap;

public class TriangleStrategy implements IShapeStrategy {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Graphics2D graphics2d;
    private Shape shape;



    public TriangleStrategy(Graphics2D graphics, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {
        this.graphics2d = graphics;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
    }

    @Override
    public Color EnumColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor, Color> color = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor,color);
        Color colorChosen = color.get(shapeColor);

        return colorChosen;
    }

    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                int[] xF = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryF = EnumColorMap(primaryColor);

                graphics2d.setColor(primaryF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillPolygon(xF, yF, 3);
                break;

            case OUTLINE:
                int[] xO = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yO = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryO = EnumColorMap(primaryColor);

                graphics2d.setColor(primaryO);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawPolygon(xO, yO, 3);
                break;

            case OUTLINE_AND_FILLED_IN:
                int[] xOF = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yOF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };
                Color primaryOF = EnumColorMap(primaryColor);
                graphics2d.setColor(primaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillPolygon(xOF, yOF, 3);

                Color secondaryOF = EnumColorMap(secondaryColor);
                graphics2d.setColor(secondaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawPolygon(xOF, yOF, 3);
                break;



        }

    }


}

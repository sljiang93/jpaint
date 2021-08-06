package model;

import model.interfaces.IShapeStrategy;
import controller.MouseClick;
import java.awt.*;
import java.util.EnumMap;

public class TriangleStrategy implements IShapeStrategy {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Graphics2D graphics;
    private Shape shape;



    public TriangleStrategy(Graphics2D graphics, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {
        this.graphics = graphics;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
    }

    @Override
    public Color EnumColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor, Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor,colorMap);
        Color colorMapped = colorMap.get(shapeColor);

        return colorMapped;
    }

    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                int[] xCordsF = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCordsF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryF = EnumColorMap(primaryColor);

                graphics.setColor(primaryF);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillPolygon(xCordsF, yCordsF, 3);
                break;

            case OUTLINE:
                int[] xCordsO = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCordsO = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                Color primaryO = EnumColorMap(primaryColor);

                graphics.setColor(primaryO);
                graphics.setStroke(new BasicStroke(5));
                graphics.drawPolygon(xCordsO, yCordsO, 3);
                break;

            case OUTLINE_AND_FILLED_IN:
                int[] xCordsOF = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCordsOF = {shape.getYMax(), shape.getYMin(), shape.getYMax() };
                Color primaryOF = EnumColorMap(primaryColor);
                graphics.setColor(primaryOF);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillPolygon(xCordsOF, yCordsOF, 3);

                Color secondaryOF = EnumColorMap(secondaryColor);
                graphics.setColor(secondaryOF);
                graphics.setStroke(new BasicStroke(5));
                graphics.drawPolygon(xCordsOF, yCordsOF, 3);
                break;



        }

    }


}

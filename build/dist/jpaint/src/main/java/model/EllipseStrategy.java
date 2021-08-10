package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.awt.Graphics2D;
import java.util.EnumMap;

public class EllipseStrategy implements IShapeStrategy {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shapeShadingType;
    private Graphics2D graphics;
    private Shape shape;


    public EllipseStrategy(Graphics2D graphics, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {
        this.graphics = graphics;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
    }

    @Override
    public Color EnumColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor,colorMap);
        Color colorMapped = colorMap.get(shapeColor);

        return colorMapped;
    }

    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                Color primaryF = EnumColorMap(primaryColor);
                graphics.setColor(primaryF);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE:
                Color primaryO = EnumColorMap(primaryColor);
                graphics.setColor(primaryO);
                graphics.setStroke(new BasicStroke(5));
                graphics.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE_AND_FILLED_IN:
                Color primaryOF = EnumColorMap(primaryColor);
                graphics.setColor(primaryOF);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

                Color secondaryOF = EnumColorMap(secondaryColor);
                graphics.setColor(secondaryOF);
                graphics.setStroke(new BasicStroke(5));
                graphics.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;


        }

    }


}


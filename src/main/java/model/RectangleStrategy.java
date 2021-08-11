package model;

import model.interfaces.IShape;

import java.awt.*;
import java.util.EnumMap;
import java.awt.Graphics2D;

public class RectangleStrategy implements IShape {
    private ShapeColor primaryColor, secondaryColor;
    private Graphics2D graphics2d;
    private Shape shape;


    public RectangleStrategy(ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape, Graphics2D graphics) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.graphics2d = graphics;
    }

    @Override
    public Color EnumColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor,Color> color = new EnumMap<>(ShapeColor.class);
        ColorClass colorSingleton = ColorClass.getColor(shapeColor,color);
        Color colorChosen = color.get(shapeColor);
        return colorChosen;
    }

    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                Color primaryF = EnumColorMap(primaryColor);
                graphics2d.setColor(primaryF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE:
                Color primaryO = EnumColorMap(primaryColor);
                graphics2d.setColor(primaryO);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE_AND_FILLED_IN:
                Color primaryOF = EnumColorMap(primaryColor);
                graphics2d.setColor(primaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

                Color secondaryOF = EnumColorMap(secondaryColor);
                graphics2d.setColor(secondaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;


        }

    }
}
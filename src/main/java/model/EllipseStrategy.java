package model;

import model.interfaces.IShape;
import model.ColorAdapter;
import java.awt.*;
import java.util.EnumMap;

public class EllipseStrategy implements IShape {
    private ShapeShadingType shapeShadingType;
    private Graphics2D graphics2d;
    private ShapeColor primaryColor,secondaryColor;
    private Shape shape;
    private Color color;



    public EllipseStrategy(ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape, Graphics2D graphics2d) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.graphics2d = graphics2d;
    }


    @Override
    public void draw() {
        switch(shape.shadingType){
            case FILLED_IN:
                Color primaryF = ColorMap(primaryColor);
                graphics2d.setColor(primaryF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE:
                Color primaryO = ColorMap(primaryColor);
                graphics2d.setColor(primaryO);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;

            case OUTLINE_AND_FILLED_IN:
                Color primaryOF = ColorMap(primaryColor);
                graphics2d.setColor(primaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

                Color secondaryOF = ColorMap(secondaryColor);
                graphics2d.setColor(secondaryOF);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                break;


        }

    }


    public Color ColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor, Color> color = new EnumMap<>(ShapeColor.class);
        ColorAdapter.getColor(shapeColor,color);
        return color.get(shapeColor);
    }


}


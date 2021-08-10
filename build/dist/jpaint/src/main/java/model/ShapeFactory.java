package model;
import model.interfaces.IApplicationState;

import java.awt.*;
import java.util.List;
public class ShapeFactory {

    public IApplicationState appState;
    public ShapeList shapeList;

    public Shape shape;
    private List<Shape> selectedShapeList;
    private List<Shape> copiedShapeList;


    public ShapeFactory(IApplicationState appState, ShapeList shapeList,List<Shape> selectedShapeList, List<Shape> copiedShapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.copiedShapeList= copiedShapeList;

    }
}














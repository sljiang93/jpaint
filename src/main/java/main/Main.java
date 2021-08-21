package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseClick;
import model.DrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.Shape;
import model.ShapeMaker;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import java.util.List;

import model.ShapeList;
import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        List<Shape> selectedShapeList = new ArrayList<>();
        List<Shape> masterShapeList = new ArrayList<>();
        List<Shape> copiedShapeList = new ArrayList<>();
        List<Shape>movedShapeList = new ArrayList<>();
        List<Shape>whiteOutList = new ArrayList<>();
        List<Shape>copyList= new ArrayList<>();
        List<Shape> commandHistoryUndo = new ArrayList<>();
        List<Shape> commandHistoryRedo = new ArrayList<>(); ;
        List<Shape> groupList = new ArrayList<>();
        IShape shapeStrategy=null;
        ShapeList shapeList = new ShapeList(new DrawShapeStrategy(paintCanvas,shapeStrategy), masterShapeList, commandHistoryUndo, commandHistoryRedo,selectedShapeList, groupList,copyList);
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList,  selectedShapeList, copiedShapeList,commandHistoryUndo,commandHistoryRedo, groupList);
        ShapeMaker shapeMaker = new ShapeMaker(appState, shapeList, selectedShapeList, movedShapeList, copiedShapeList,groupList,whiteOutList);
        MouseClick mouseClick = new MouseClick(shapeMaker);


        paintCanvas.addMouseListener(mouseClick);

        controller.setup();

    }
}

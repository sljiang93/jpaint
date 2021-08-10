package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseClick;
import model.Shape;
import model.ShapeFactory;
import model.DrawShapeHandler;
import model.interfaces.IShapeStrategy;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import java.util.List;

import model.ShapeList;

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

        List<Shape> commandHistoryUndo = new ArrayList<>();
        List<Shape> commandHistoryRedo = new ArrayList<>(); ;


        IShapeStrategy shapeStrategy=null;

        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas, shapeStrategy), masterShapeList, commandHistoryRedo, commandHistoryRedo);


        IJPaintController controller = new JPaintController(uiModule, appState, shapeList,  commandHistoryRedo, commandHistoryRedo, commandHistoryRedo, commandHistoryRedo, paintCanvas);


        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList, commandHistoryRedo, commandHistoryRedo);


        MouseClick mouseClick = new MouseClick(shapeFactory);


        paintCanvas.addMouseListener(mouseClick);

        controller.setup();

    }
}

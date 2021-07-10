package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;

public class Main {




    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        //JFrame window = new JFrame("Rectangles");
        //window.getContentPane().addMouseListener(new MouseClick());
        //window.setSize(500,500);
        //window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //window.setVisible(true);
        MouseClick mouseClick = new MouseClick (paintCanvas,appState);
        paintCanvas.addMouseListener(mouseClick);
        paintCanvas.addMouseMotionListener(mouseClick);

        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));

        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        //graphics2d.fillRect(12,13,200,400);
        graphics2d.drawRect(mouseClick.x, mouseClick.y, mouseClick.w, mouseClick.h);
        System.out.println(mouseClick.x);
        System.out.println(mouseClick.y);


        //print (int x);
        //print (int y);
        //System.out.println(x+", "+y);

        //graphics2d.draw(new Rectangle(12,13,200,400));

        // Outlined rectangle
        //graphics2d.setStroke(new BasicStroke(5));
        //graphics2d.setColor(Color.BLUE);
        //graphics2d.drawRect(12, 13, 200, 400);

// Selected Shape
        //Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        //graphics2d.setStroke(stroke);
        //graphics2d.setColor(Color.BLACK);
        //graphics2d.drawRect(7, 8, 210, 410);











        // For example purposes only; remove all lines below from your final project.


        // end of example
    }
    //public void drawRect (int)



}

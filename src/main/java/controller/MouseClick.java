package controller;

import model.*;
import model.interfaces.ICommand;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    public ShapeFactory shapeFactory;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public String clickType;


    public MouseClick(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public void mousePressed(MouseEvent e) {
        int xP = e.getX();
        int yP = e.getY();
        startPoint = new Point(xP, yP);
    }

    public void mouseReleased(MouseEvent e) {

        shapeType = shapeFactory.appState.getActiveShapeType();
        int xR = e.getX();
        int yR = e.getY();
        endPoint = new Point(xR, yR);


        if(e.getButton() == MouseEvent.BUTTON1){
            clickType = "LEFT";
        }

        if(e.getButton() == MouseEvent.BUTTON3){
            clickType = "RIGHT";
        }

        ICommand shapeCommand = null;

        if(shapeFactory.appState.getActiveStartAndEndPointMode()== StartAndEndPointMode.DRAW) {
            shapeCommand = new CreateShapeCommand(shapeFactory, shapeType, startPoint, endPoint, clickType);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.SELECT) {
            shapeCommand = new SelectShapeCommand(shapeFactory,startPoint, endPoint);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.MOVE){
        shapeCommand = new MoveCommand(shapeFactory, shapeType, startPoint, endPoint);
        }

        shapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) { }

    public void mouseDragged(MouseEvent e){ }


}
//}

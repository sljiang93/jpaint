package controller;

import model.*;
import model.interfaces.ICommand;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    public ShapeMaker shapeMaker;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public String clickType;


    public MouseClick(ShapeMaker shapeMaker) {
        this.shapeMaker = shapeMaker;
    }

    public void mousePressed(MouseEvent e) {
        int xP = e.getX();
        int yP = e.getY();
        startPoint = new Point(xP, yP);
    }

    public void mouseReleased(MouseEvent e) {

        shapeType = shapeMaker.appState.getActiveShapeType();
        int xR = e.getX();
        int yR = e.getY();
        endPoint = new Point(xR, yR);


       

        ICommand shapeCommand = null;

        if(shapeMaker.appState.getActiveMouseMode()== MouseMode.DRAW) {
            shapeCommand = new CreateShapeCommand(shapeMaker, shapeType, startPoint, endPoint/*, clickType*/);
        }
        else if(shapeMaker.appState.getActiveMouseMode()==MouseMode.SELECT) {
            shapeCommand = new SelectShapeCommand(shapeMaker,startPoint, endPoint);
        }
        else if(shapeMaker.appState.getActiveMouseMode()==MouseMode.MOVE){
        shapeCommand = new MoveCommand(shapeMaker, shapeType, startPoint, endPoint);
        }

        shapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) { }

    public void mouseDragged(MouseEvent e){ }


}


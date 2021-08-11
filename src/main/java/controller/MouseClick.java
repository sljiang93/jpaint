package controller;

import model.*;
import model.Shape;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Container;
import java.awt.Component;
import javax.swing.*;
import model.MouseMode;


public class MouseClick extends MouseAdapter {

    public ShapeMaker shapeMaker;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public String clickType;
    public Shape shape;
    public Graphics2D graphics2d;
    public Point initMove;
    public Point endMove;


    public MouseClick(ShapeMaker shapeMaker) {
        this.shapeMaker = shapeMaker;
    }

    public void mousePressed(MouseEvent e) {
        int xP = e.getX();
        int yP = e.getY();
        startPoint = new Point(xP, yP);
        //initMove = new Point (xP,yP);
    }

    public void mouseReleased(MouseEvent e) {

        shapeType = shapeMaker.appState.getActiveShapeType();
        int xR = e.getX();
        int yR = e.getY();
        endPoint = new Point(xR, yR);
        //endMove = new Point(xR,yR);
       

        //shape = new Shape(shapeType, startPoint, endPoint);


       

        ICommand shapeManeuver = null;

       

  

        if(shapeMaker.appState.getActiveMouseMode()== MouseMode.DRAW) {
            shapeManeuver = new CreateShapeCommand(shapeMaker, shapeType, startPoint, endPoint);
        }
        else if(shapeMaker.appState.getActiveMouseMode()==MouseMode.SELECT) {
            shapeManeuver = new SelectShapeCommand(shapeMaker, startPoint, endPoint, shapeType);
        }
        else if(shapeMaker.appState.getActiveMouseMode()==MouseMode.MOVE){
        shapeManeuver = new MoveCommand(shapeMaker, startPoint, endPoint, shape);
        }

        shapeManeuver.run();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseDragged(MouseEvent e){

        
       
      
     }


}


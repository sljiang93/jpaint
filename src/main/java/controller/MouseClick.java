package controller;

import model.*;
import model.Shape;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;
import model.persistence.ApplicationState;
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
    public Shape shape;
    public Graphics2D graphics2d;
    public Point initMove;
    public Point endMove;
    public Point mousePressed,mouseReleased;


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
       

       

        ICommand shapeManeuver = null;

       
        switch(shapeMaker.appState.getActiveMouseMode()){
            
            case DRAW:
            shapeManeuver=new CreateShape(shapeMaker, shapeType, startPoint, endPoint);
            break;
            case SELECT:
            shapeManeuver = new SelectShapeCommand(shapeMaker, startPoint, endPoint, shapeType);
            break;
            case MOVE:
            shapeManeuver = new MoveCommand(shapeMaker,startPoint, endPoint, shapeType);
            break;}


        shapeManeuver.run();
    }



}


package model.ShapeMaker;

import controller.ICommand;
import controller.cmdHistory;
import controller.cmdRedo;
import controller.cmdUndo;
import controller.IUndoable;
import model.ShapeConfig;
import model.ShapeType;
import view.gui.MouseClick;

import java.awt.*;


public class CreateShape implements ICommand, IUndoable{
    public Point startP;
    public Point endP;
    public int x;
    public int y;
    public int w;
    public int h;
    //public
    public CreateShape shape;
    public ShapeType shapeType;
    Color Color1;
    Color Color2;

    public CreateShape (ShapeType shapeType, Point StartP, Point endP, int x, int y, int w, int h, ShapeConfig ShapeConfig){
        this.shapeType=shapeType;
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.startP=startP;
        this.endP=endP;

    }

    @Override
    public void run() {

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}

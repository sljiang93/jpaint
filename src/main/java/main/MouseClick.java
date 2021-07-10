package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick extends MouseAdapter{
    public boolean click = false;
    public int x;
    public int y;
    public int w;
    public int h;
    private IApplicationState appState;
    private PaintCanvasBase canvas;
    private Point startP = new Point(0,0);
    private Point endP = new Point(0,0);

    public MouseClick (PaintCanvasBase canvas, IApplicationState appState){
        this.canvas=canvas;
        this.appState=appState;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //super.mouseClicked(e);
        click = true;
        super.mouseClicked(e);
        System.out.println(e.getX()+" ," +e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startP = e.getPoint();
        x=e.getX();
        y=e.getY();
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        endP = e.getPoint();
        w=e.getX();
        h=e.getY();
    }
}
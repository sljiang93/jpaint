package model.ShapeMaker;

import view.gui.PaintCanvas;
import view.gui.MouseClick;
import java.awt.Graphics2D;
import java.awt.Color;
import view.gui.MouseClick;

public class DrawShape implements IShape{
    private PaintCanvas canvas;
    static DrawShape drawShape;
    static Graphics2D graphics2d;


    @Override
    public void update() {
        graphics2d.fillRect(0,0,1000,1000);
    }
}

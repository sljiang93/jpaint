package model;

import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;
import controller.IJPaintController;
import java.util.List;

public class CopyCommand implements ICommand{
    public ShapeList shapeList;
    public List<Shape> selectedList;
    public List<Shape> copyList;

    public CopyCommand(ShapeList shapeList,List<Shape>selectedList,List<Shape>copyList){
        this.selectedList=selectedList;
        this.copyList=copyList;
        this.shapeList=shapeList;

    }

    public void copy(List<Shape> selectList){
        for (Shape shape: selectList){
            copyList.add(shape);
        }
    }

    @Override
    public void run() {

        if (!selectedList.isEmpty()){
            copy(selectedList);
            System.out.println("Shape copied.");}

        // TODO Auto-generated method stub
        
    }
    
    
}

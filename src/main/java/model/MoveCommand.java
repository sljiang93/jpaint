package model;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.ICommand;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShapeStrategy;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.CreateShapeCommand;
import model.ShapeList;
import java.awt.Point;

public class MoveCommand implements ICommand,IUndoable {

    public ShapeMaker shapeFactory;
    public ShapeType shapeType;
    public Point mousePress;
    public Point mouseRelease;
    public static CreateShapeCommand beforeShape;
    public static CreateShapeCommand afterShape;
    public ApplicationState applicationState;
    public String clickType;

    public List<Shape> moveList = new ArrayList<>();
    public static List<CreateShapeCommand> beforeShapes = new ArrayList<CreateShapeCommand>();
	public static List<CreateShapeCommand> afterShapes = new ArrayList<CreateShapeCommand>();
    public int dX,dY;
    public IDrawShapeHandler selectedShape;

    public MoveCommand (ShapeMaker shapeFactory, ShapeType shapeType, Point mousePress, Point mouseRelease){
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.mousePress = mousePress;
        this.mouseRelease = mouseRelease;
    }

    

    @Override
    public void undo() {
        undo();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void redo() {
        redo();
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        SelectShapeCommand selectCommand = new SelectShapeCommand(shapeFactory, mousePress, mouseRelease);
        selectCommand.run();
        selectedShape = selectCommand.getSeletectedShape();
        double dX = (double) applicationState.getAdjustedEnd().getX() - applicationState.getAdjustedStart().getX();
        double dY = (double) applicationState.getAdjustedEnd().getY() - applicationState.getAdjustedStart().getY();

        selectedShape.addX(dX);
        selectedShape.addY(dY);

        CreateShapeCommand createShapeCommand = new CreateShapeCommand(shapeFactory, shapeType, mousePress, mouseRelease,clickType);
        createShapeCommand.run();




        

        // TODO Auto-generated method stub
        
    }
    
}

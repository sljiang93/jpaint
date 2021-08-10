package model.persistence;

import model.*;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import java.awt.Point;
import controller.MouseClick;

public class ApplicationState implements IApplicationState{

    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;
    private Point startPoint;
    private Point endPoint;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public void CopyCommand() { }  

    @Override
    public void DeleteCommand() { }

    @Override
    public void PasteCommand() { }

    @Override
    public void UndoCommand() { }

    @Override
    public void RedoCommand() { }
    

    @Override
    public ShapeType getActiveShapeType() { return activeShapeType; }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }

    public Point getStartPoint(){
        return startPoint;
    }

    public Point getEndPoint(){
        return endPoint;
    }

    
    public Point getAdjustedStart(){
        double startX = Math.min(startPoint.getX(), endPoint.getX());
        double startY = Math.min(startPoint.getY(), endPoint.getY());
        return new Point();
    }

    public Point getAdjustedEnd(){
        double endX = Math.max(startPoint.getX(), endPoint.getX());
        double endY = Math.max(startPoint.getY(), endPoint.getY());
        return new Point();
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }
}

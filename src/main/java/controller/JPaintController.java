package controller;

import model.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;
import model.Shape;
import java.util.List;
import java.util.ArrayList;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;
    public List<Shape> copiedShapeList;
    public PaintCanvas paintCanvas;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, List<Shape> selectedShapeList,
                            List<Shape> copiedShapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.selectedShapeList = selectedShapeList;
        this.copiedShapeList = copiedShapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        //uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(applicationState, shapeList).run());//applicationState.DeleteCommand());
        //uiModule.addEvent(EventName.COPY, () -> new CopyCommand(selectedShapeList, copiedShapeList, shapeList).run());
        //uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(copiedShapeList, shapeList).run());

        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand(shapeList,commandHistoryUndo, commandHistoryRedo).run());
        //uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand(shapeList,commandHistoryUndo,commandHistoryRedo).run());
    }
}

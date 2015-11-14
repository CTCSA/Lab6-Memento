import java.awt.*;
import java.awt.event.*;

public class CreateShapeControl extends PanelControl {

  public CreateShapeControl() {
  }

  public CreateShapeControl(CommandStack cs, Diagram d) {
    super(cs, d);
  }

  public void mousePressed(MouseEvent e) {
    Shape newShape = new Shape(e.getX(), e.getY());
    this._commandStack.createShape(newShape, true);
    this._diagram.add(newShape);
    ((DrawingPanel) e.getSource()).repaint();
  }

  public void mouseReleased(MouseEvent e) {
    ((DrawingPanel) e.getSource()).restoreControl();
  }
}
import java.awt.*;
import java.awt.event.*;

public class MoveControl extends PanelControl {
  private Shape _dragShape;
  private int _pressX, _pressY;

  public MoveControl(CommandStack cs, Diagram d) {
    super(cs, d);
  }

  public void mousePressed(MouseEvent e) {
    _dragShape = this._diagram.getShape(e.getX(), e.getY());
    if (_dragShape != null) {
      _commandStack.remember(_dragShape, true);
      _pressX = _dragShape.getX() - e.getX();
      _pressY = _dragShape.getY() - e.getY();
    }
  }

  public void mouseDragged(MouseEvent e) {
    if (_dragShape != null) {
      _dragShape.setLocation(e.getX() + _pressX, e.getY() + _pressY);
      ((DrawingPanel) e.getSource()).repaint();
    }
  }

  public void mouseReleased(MouseEvent e) {
    _dragShape = null;
  }
}


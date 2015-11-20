package DrawingTool;

import java.awt.*;
import java.awt.event.*;


public class CreateLineControl extends PanelControl {

  PolyLine _line;

  public CreateLineControl() {
  }

  public CreateLineControl(CommandStack cs, Diagram d) {
    super(cs, d);
    _line = null;
  }

  public void mousePressed(MouseEvent e) {
    if (e.getClickCount() > 1) {
      ((DrawingPanel) e.getSource()).restoreControl();
      _line = null;
      return;
    }
    if (_line == null) {
      _line = new PolyLine(e.getX(), e.getY());
      this._commandStack.createShape(_line, true);
      this._diagram.add(_line);
    } else {
      _line.addPoint(e.getX(), e.getY());

    }
    ((DrawingPanel) e.getSource()).repaint();
  }
}

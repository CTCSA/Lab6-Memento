import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

class DrawingPanel extends JPanel {

  private Diagram _diagram;
  private CommandStack _commandStack;
  private PanelControl _moveControl = new MoveControl(_commandStack, _diagram);
  private PanelControl _currentControl = _moveControl;
  private PanelControl _createShapeControl = new CreateShapeControl(_commandStack, _diagram);

  public DrawingPanel(Diagram d, CommandStack cs, java.awt.List list) {
    super();
    _diagram = d;
    _commandStack = cs;
    _moveControl = new MoveControl(_commandStack, _diagram);
    _currentControl = _moveControl;
    _createShapeControl = new CreateShapeControl(_commandStack, _diagram);
    this.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        _currentControl.mousePressed(e);
      }

      public void mouseReleased(MouseEvent e) {
        _currentControl.mouseReleased(e);
      }
    });

    this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        _currentControl.mouseDragged(e);
      }
    });
  }

  public void restoreControl() {
    _currentControl = _moveControl;
  }

  public void setControl(PanelControl con) {
    _currentControl = con;
  }

  public void paint(Graphics g) {
    g.setColor(Color.white);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    Enumeration en = this._diagram.getShapes();
    while (en.hasMoreElements()) {
      ((Shape) en.nextElement()).draw(g);
    }
  }


  public void undo() {
    this._commandStack.undo();
    this.repaint();
  }

  public void redo() {
    this._commandStack.redo();
    this.repaint();
  }

  public void clear() {
    this._diagram.clear();
    this._commandStack.clearStack();
    this.repaint();

  }
}
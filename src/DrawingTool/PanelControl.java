import java.awt.*;
import java.awt.event.*;

public class PanelControl extends MouseAdapter implements MouseMotionListener {
  protected Diagram _diagram;
  protected CommandStack _commandStack;

  public PanelControl() {
  }

  public PanelControl(CommandStack cs, Diagram d) {
    _diagram = d;
    _commandStack = cs;
  }

  public void mouseMoved(MouseEvent e) {
  }

  public void mouseDragged(MouseEvent e) {
  }
}
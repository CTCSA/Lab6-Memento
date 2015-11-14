import javax.swing.JButton;
import java.lang.reflect.*;
/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class ShapeButton extends JButton {

  private PanelControl _control;

  public ShapeButton(String label, String controlClass, CommandStack commandStack, Diagram diagram) {
    super(label);
    try {
      Class cl = Class.forName(controlClass);
      Class[] paraClass = {CommandStack.class, Diagram.class};
      Constructor constructor = cl.getConstructor(paraClass);
      Object para[] = {commandStack, diagram};
      _control = (PanelControl) constructor.newInstance(para);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public PanelControl getControl() {
    return _control;
  }
}

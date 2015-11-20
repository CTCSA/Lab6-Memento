package DrawingTool;

import java.util.*;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class Diagram {

  Vector _shapes = new Vector();

  public Diagram() {
  }

  public void add(Shape shape) {
    _shapes.add(shape);
  }

  public void remove(Shape shape) {
    _shapes.remove(shape);
  }

  public Enumeration getShapes() {
    return _shapes.elements();
  }

  public Shape getShape(int x, int y) {
    Enumeration en = getShapes();
    while (en.hasMoreElements()) {
      Shape shape = (Shape) en.nextElement();
      if (shape.contains(x, y))
        return(shape);
    }
    return null;
  }

  public void clear() {
    _shapes.clear();
  }
}

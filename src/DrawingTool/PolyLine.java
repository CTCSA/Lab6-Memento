import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

public class PolyLine extends Shape {

  private Vector _points = new Vector();

  public PolyLine(int x, int y) {
    super(x, y);
    _width = 0;
    _height = 0;
    _points.add(new Point(0,0));
  }

  void addPoint(int x, int y) {
    int minX, minY, maxX, maxY;
    int newMinX, newMinY, newMaxX, newMaxY;
    minX = _x;
    minY = _y;
    maxX = minX + _width;
    maxY = minY + _height;
    newMinX = Math.min(minX, x);
    newMinY = Math.min(minY, y);
    newMaxX = Math.max(maxX, x);
    newMaxY = Math.max(maxY, y);
    for (int i = 0; i < _points.size(); i++) {
      Point p = (Point) _points.elementAt(i);
      p.translate(minX - newMinX, minY - newMinY);
    }
    _x = newMinX;
    _y = newMinY;
    _width = newMaxX - _x + 1;
    _height = newMaxY - _y + 1;
    _points.add(new Point(x - _x ,y - _y));
  }

  public void draw(Graphics g) {
    g.setColor(Color.black);
    Point p1 = (Point) _points.elementAt(0);
    for (int i = 1; i < _points.size(); i++) {
      Point p2 = (Point) _points.elementAt(i);
      g.drawLine((int) p1.getX()+_x, (int) p1.getY()+_y, (int) p2.getX()+_x, (int) p2.getY()+_y);
      p1 = p2;
    }
    g.drawString(String.valueOf(this._id), this._x, this._y + g.getFontMetrics().getHeight());
  }
}
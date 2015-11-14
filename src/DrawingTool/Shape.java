import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

class Shape {
  protected static int _idCounter = 0;
  protected int _x, _y, _width = 20, _height = 20, _id;

  public Shape(int x, int y) {
    this._x = x;
    this._y = y;
    this._id = ++_idCounter;

  }

  public void draw(Graphics g) {
    g.setColor(Color.black);
    g.drawRect(_x, _y, _width, _height);
    g.drawString(String.valueOf(this._id), this._x, this._y + g.getFontMetrics().getHeight());

  }

  public boolean contains(int x, int y) {
    return (x >= this._x && y >= this._y && x <= this._x + this._width && y <= this._y + this._height);
  }

  public void setLocation(int x, int y) {
    this._x = x;
    this._y = y;
  }

  public void setSize(int width, int height) {
    this._width = width;
    this._height = height;
  }

  public int getX() {
    return this._x;
  }

  public int getY() {
    return this._y;
  }

  public int getWidth() {
    return this._width;
  }

  public int getHeight() {
    return this._height;
  }

  public String toString() {
    return "Create: Shape(" + this.getId() + ")";
  }

  public int getId() {
    return this._id;
  }
}

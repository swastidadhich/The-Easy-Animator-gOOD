package cs3500.animator.view;

import cs3500.animator.model.Shape2D;
import cs3500.animator.model.Motion2D;
import cs3500.animator.view.drawing.IViewShape;
import cs3500.animator.view.drawing.ViewOval;
import cs3500.animator.view.drawing.ViewRect;

/**
 * A utilities class to get the last tick in a model (getLastTick), calculate a tweened value
 * (numAtTick), or tween a model shape to a view shape (tween).
 */
public class Utilities {

  /**
   * Constructs a Utilities.
   */
  public Utilities() {
    // utilities class does not require fields
  }

  /**
   * Finds the new x and y positions, color, and dimensions of the given model shape with
   * tweening using the given motion and tick, and returns these newly tweened state as a view
   * shape.
   * @param s model shape
   * @param m motion
   * @param tick tick at which to find the state
   * @return a view shape with a state that of the given tick
   */
  protected IViewShape tween(Shape2D s, Motion2D m, int tick) {

    if (tick > m.getTick2() || tick < m.getTick1()) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    int x = (int) Math.round(numAtTick(m.getX1(), m.getX2(), tick, m));
    int y = (int) Math.round(numAtTick(m.getY1(), m.getY2(), tick, m));
    int r = (int) Math.round(numAtTick(m.getRed1(), m.getRed2(), tick, m));
    int g = (int) Math.round(numAtTick(m.getGreen1(), m.getGreen2(), tick, m));
    int b = (int) Math.round(numAtTick(m.getBlue1(), m.getBlue2(), tick, m));
    int w = (int) Math.round(numAtTick(m.getWidth1(), m.getWidth2(), tick, m));
    int h = (int) Math.round(numAtTick(m.getHeight1(), m.getHeight2(), tick, m));

    return toViewShape(s, x, y, w, h, r, g, b);
  }

  /**
   * Calculates the value of a number at the given tick between this motion's starting tick
   * (represented by the first number) and ending tick (represented by the second given number).
   *
   * @param tick given tick
   * @return the number at the given tick, the tweened value
   */
  protected double numAtTick(int num1, int num2, double tick, Motion2D m) {

    double deltaZ;
    double percentT;
    int t1 = m.getTick1();
    int t2 = m.getTick2();

    deltaZ = num2 - num1;
    percentT = (tick - t1) / (t2 - t1);

    return (deltaZ * percentT) + num1;
  }

  /**
   * Returns a view shape of the type of the given model shape and with a state that of the given x
   * and y positions, width, height, and color.
   * @param s model shape
   * @param x x-position
   * @param y y-position
   * @param w width
   * @param h height
   * @param r red
   * @param g green
   * @param b blue
   * @return a view shape of the model's shapes type and with the given values as its state
   */
  protected IViewShape toViewShape(Shape2D s, int x, int y, int w, int h, int r, int g, int b) {
    IViewShape vs;
    java.awt.Color c = new java.awt.Color(r, g, b);

    switch (s.getType()) {
      case "rectangle":
      case "square":
        vs = new ViewRect(x, y, w, h, c);
        break;
      case "ellipse":
      case "circle":
        vs = new ViewOval(x, y, w, h, c);
        break;
      default:
        throw new IllegalArgumentException("invalid shape");
    }
    return vs;
  }

}

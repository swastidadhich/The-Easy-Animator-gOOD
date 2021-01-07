package cs3500.animator.view.drawing;

import java.awt.Graphics;
import java.awt.Color;

/**
 * A class to represent a view oval.
 */
public class ViewOval extends AbstractViewShape {

  /**
   * Constructs a ViewOval with an x-position, y-position, width, height, and color.
   *
   * @param x     the x-position
   * @param y     the y-position
   * @param w     width
   * @param h     height
   * @param color color
   */
  public ViewOval(int x, int y, int w, int h, Color color) {
    super(x, y, w, h, color);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, w, h);
  }

}

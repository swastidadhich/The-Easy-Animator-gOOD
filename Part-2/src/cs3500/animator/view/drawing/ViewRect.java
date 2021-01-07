package cs3500.animator.view.drawing;

import java.awt.Graphics;
import java.awt.Color;

/**
 * A class to represent a rectangle in the view.
 */
public class ViewRect extends AbstractViewShape {

  /**
   * Constructs a ViewRect with an x-position, y-position, width, height, and color.
   * @param x the x-position
   * @param y the y-position
   * @param w width
   * @param h height
   * @param color color
   */
  public ViewRect(int x, int y, int w, int h, Color color) {
    super(x, y, w, h, color);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, w, h);
  }

}

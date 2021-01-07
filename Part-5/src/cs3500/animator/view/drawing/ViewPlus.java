package cs3500.animator.view.drawing;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class to represent a plus view shape.
 */
public class ViewPlus extends AbstractViewShape {

  /**
   * Constructs a ViewRect with an x-position, y-position, width, height, and color.
   * @param x the x-position
   * @param y the y-position
   * @param w width
   * @param h height
   * @param color color
   */
  public ViewPlus(int x, int y, int w, int h, Color color) {
    super(x, y, w, h, color);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y + h / 4, w, h / 2); // horizontal bar
    g.fillRect(x + w / 4, y, w / 2, h); // vertical bar
  }

  @Override
  public void drawOutline(Graphics g) {
    g.setColor(color);
    g.drawLine(x + w / 4, y, x + 3 * w / 4, y);
    g.drawLine(x + w / 4, y, x + w / 4, y + h / 4);
    g.drawLine(x + 3 * w / 4, y, x + 3 * w / 4, y + h / 4);
    g.drawLine(x, y + h / 4, x + w / 4, y + h / 4);
    g.drawLine(x + 3 * w / 4, y + h / 4, x + w, y + h / 4);
    g.drawLine(x, y + h / 4, x, y + 3 * h / 4);
    g.drawLine(x + w, y + h / 4, x + w, y + 3 * h / 4);
    g.drawLine(x, y + 3 * h / 4, x + w / 4, y + 3 * h / 4);
    g.drawLine(x + 3 * w / 4, y + 3 * h / 4, x + w, y + 3 * h / 4);
    g.drawLine(x + w / 4, y + 3 * h / 4, x + w / 4, y + 3 * h / 4);
    g.drawLine(x + w / 4, y + 3 * h / 4, x + w / 4, y + h);
    g.drawLine(x + 3 * w / 4, y + 3 * h / 4, x + 3 * w / 4, y + h);
    g.drawLine(x + w / 4, y + h, x + 3 * w / 4, y + h);
  }

}

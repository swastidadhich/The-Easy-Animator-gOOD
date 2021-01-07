package cs3500.animator.view.drawing;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class to represent a the state of a shape.
 */
public abstract class AbstractViewShape implements IViewShape {

  protected final int x;
  protected final int y;
  protected final int w;
  protected final int h;
  protected final Color color;

  /**
   * Constructs an AbstractViewShape with an x-position, y-position, width, height, and color.
   * @param x the x-position
   * @param y the y-position
   * @param w width
   * @param h height
   * @param color color
   * @throws IllegalArgumentException if the color is null, the width or height is negative
   */
  protected AbstractViewShape(int x, int y, int w, int h, Color color) {

    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }

    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("Width and/or height cannot be negative");
    }

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
  }

  @Override
  public abstract void draw(Graphics g);

  @Override
  public abstract void drawOutline(Graphics g);

}

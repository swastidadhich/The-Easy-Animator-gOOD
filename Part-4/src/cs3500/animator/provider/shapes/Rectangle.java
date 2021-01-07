package cs3500.animator.provider.shapes;

import java.awt.Graphics;
import java.awt.Color;

/**
 * A mutable rectangle with a position, size, color and readonly type.
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructs a new rectangle with the given properties.
   *
   * @param x      the x-coordinate of the top-left corner of the new rectangle
   * @param y      the y-coordinate of the top-left corner of the new rectangle
   * @param width  the width of the new rectangle
   * @param height the height of the new rectangle
   * @param red    the intensity of the red channel of the new rectangle's color
   * @param green  the intensity of the green channel of the new rectangle's color
   * @param blue   the intensity of the blue channel of the new rectangle's color
   * @throws IllegalArgumentException if the color or size is invalid
   */
  public Rectangle(int x, int y, int width, int height, int red, int green, int blue) {
    super(x, y, width, height, red, green, blue);
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public void render(Graphics g) {
    g.setColor(new Color(this.getRed(), this.getGreen(), this.getBlue()));
    g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }
}


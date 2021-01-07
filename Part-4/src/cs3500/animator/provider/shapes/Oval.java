package cs3500.animator.provider.shapes;

import java.awt.Graphics;
import java.awt.Color;

/**
 * A mutable oval with a position, size, color and readonly type.
 */
public class Oval extends AbstractShape {

  /**
   * Constructs a new oval with the given properties.
   *
   * @param x      the x-coordinate of the top-left corner of the new oval
   * @param y      the y-coordinate of the top-left corner of the new oval
   * @param width  the width of the new oval
   * @param height the height of the new oval
   * @param red    the intensity of the red channel of the new oval's color
   * @param green  the intensity of the green channel of the new oval's color
   * @param blue   the intensity of the blue channel of the new oval's color
   * @throws IllegalArgumentException if the color or size is invalid
   */
  public Oval(int x, int y, int width, int height, int red, int green, int blue) {
    super(x, y, width, height, red, green, blue);
  }

  @Override
  public ShapeType getType() {
    return ShapeType.OVAL;
  }

  @Override
  public void render(Graphics g) {
    g.setColor(new Color(this.getRed(), this.getGreen(), this.getBlue()));
    g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }
}
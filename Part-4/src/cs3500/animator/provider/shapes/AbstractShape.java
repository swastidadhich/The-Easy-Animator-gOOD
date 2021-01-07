package cs3500.animator.provider.shapes;

import cs3500.animator.util.ValidationUtil;
import cs3500.animator.view.drawing.IViewShape;

import java.awt.Graphics;
import java.util.Objects;

/**
 * Defines getters and setters for shapes that implements {@link IViewShape} interface, and by
 * extension, the {@link IReadOnlyShape} interface as well.
 */
public abstract class AbstractShape implements IReadOnlyShape {

  private int x;
  private int y;

  private int width;
  private int height;
  // INVARIANT: width and height are non-negative

  private int red;
  private int green;
  private int blue;
  // INVARIANT: red, green and blue are in the range [0,256)

  /**
   * Constructs a new shape with the given properties.
   *
   * @param x      the x-coordinate of the top-left corner of the new shape
   * @param y      the y-coordinate of the top-left corner of the new shape
   * @param width  the width of the new shape
   * @param height the height of the new shape
   * @param red    the intensity of the red channel of the new shape's color
   * @param green  the intensity of the green channel of the new shape's color
   * @param blue   the intensity of the blue channel of the new shape's color
   * @throws IllegalArgumentException if the color or size is invalid
   */
  public AbstractShape(int x, int y, int width, int height, int red, int green, int blue)
          throws IllegalArgumentException {
    this.x = x;
    this.y = y;
    this.width = ValidationUtil.ensureNonNegative(width);
    this.height = ValidationUtil.ensureNonNegative(height);
    this.red = ValidationUtil.ensureInRange(0, red, 256);
    this.green = ValidationUtil.ensureInRange(0, green, 256);
    this.blue = ValidationUtil.ensureInRange(0, blue, 256);
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getRed() {
    return this.red;
  }

  @Override
  public int getGreen() {
    return this.green;
  }

  @Override
  public int getBlue() {
    return this.blue;
  }

  @Override
  public abstract ShapeType getType();

  @Override
  public abstract void render(Graphics g);

  @Override
  public String toString() {
    return String
            .format("%s { position: (%d, %d), size: (%d, %d), color: (%d, %d, %d) }",
                    this.getType().name().toLowerCase(),
                    this.getX(), this.getY(),
                    this.getWidth(), this.getHeight(),
                    this.getRed(), this.getGreen(), this.getBlue());
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    } else if (!(object instanceof AbstractShape)) {
      return false;
    } else {
      IReadOnlyShape that = (AbstractShape) object;
      return this.getType() == that.getType()
              && this.getX() == that.getX()
              && this.getY() == that.getY()
              && this.getWidth() == that.getWidth()
              && this.getHeight() == that.getHeight()
              && this.getRed() == that.getRed()
              && this.getGreen() == that.getGreen()
              && this.getBlue() == that.getBlue();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getType(),
            this.getX(), this.getY(),
            this.getWidth(), this.getHeight(),
            this.getRed(), this.getGreen(), this.getBlue());
  }
}

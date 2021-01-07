package cs3500.animator.provider.shapes;

import java.awt.Graphics;

/**
 * An immutable shape with an observable size, position, color and type.
 */
public interface IReadOnlyShape {

  /**
   * Gets the x-coordinate of the top-left corner of this shape.
   *
   * @return the x-coordinate
   */
  int getX();

  /**
   * Gets the y-coordinate of the top-left corner of this shape.
   *
   * @return the y-coordinate
   */
  int getY();

  /**
   * Gets the width of this shape.
   *
   * @return the width
   */
  int getWidth();

  /**
   * Gets the height of this shape.
   *
   * @return the height
   */
  int getHeight();

  /**
   * Gets the intensity of the red channel of this shape's color.
   *
   * @return the red channel intensity
   */
  int getRed();

  /**
   * Gets the intensity of the green channel of this shape's color.
   *
   * @return the green channel intensity
   */
  int getGreen();

  /**
   * Gets the intensity of the blue channel of this shape's color.
   *
   * @return the blue channel intensity
   */
  int getBlue();

  /**
   * Gets the type of this shape.
   *
   * @return the type
   */
  ShapeType getType();

  /**
   * Renders this shape with the given {@link Graphics} context.
   *
   * @param g the graphics context
   */
  void render(Graphics g);
}

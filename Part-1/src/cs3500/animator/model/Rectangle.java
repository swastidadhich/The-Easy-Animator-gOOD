package cs3500.animator.model;

/**
 * A class to represent a rectangle 2D shape.
 */
public class Rectangle extends Shape2D {

  /**
   * Constructs a rectangle with a color, position, width, and height.
   *
   * @param color    color
   * @param position 2D position
   * @param width    width
   * @param height   height
   */

  public Rectangle(Color color, Position2D position, int width, int height) {
    super(color, position, width, height);
  }

}

package cs3500.animator.model;

/**
 * A class to represent a ellipse 2D shape.
 */
public class Ellipse extends Shape2D {

  /**
   * Constructs an ellipse with a color, position, width, and height.
   *
   * @param color    color
   * @param position 2D position
   * @param width    width
   * @param height   height
   */
  public Ellipse(Color color, Position2D position, int width, int height) {
    super(color, position, width, height);
  }
}

package cs3500.animator.model;

/**
 * A class to represent a circle 2D shape.
 */
public class Circle extends Shape2D {

  /**
   * Constructs a circle with a color, position, and width.
   *
   * @param color    color
   * @param position 2D position
   * @param width    width
   */
  public Circle(Color color, Position2D position, int width) {
    super(color, position, width);
  }
}

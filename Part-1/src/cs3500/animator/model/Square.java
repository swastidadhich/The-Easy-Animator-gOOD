package cs3500.animator.model;

/**
 * A class to represent a square 2D shape.
 */
public class Square extends Shape2D {

  /**
   * Constructs a square with a color, position, and width.
   *
   * @param color    color
   * @param position 2D position
   * @param width    width
   */
  public Square(Color color, Position2D position, int width) {
    super(color, position, width);
  }
}

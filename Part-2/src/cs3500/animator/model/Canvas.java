package cs3500.animator.model;

/**
 * Class to represent the area on which the shapes are to be animated.
 */
public class Canvas {

  private final int x;
  private final int y;
  private final int width;
  private final int height;

  /**
   * Constructs a canvas with a top-left corner (0, 0) with a width and height of 1000.
   */
  public Canvas() {
    this.x = 0;
    this.y = 0;
    this.width = 1000;
    this.height = 1000;
  }

  /**
   * Constructs a canvas with the top left corner's x-position, y-position, and a height and width.
   * @param x top left corner x-position
   * @param y top left corner y-position
   * @param width the width
   * @param height the height
   */
  public Canvas(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Gets the x-position of this canvas's top left corner.
   * @return the x-position
   */
  protected int getX() {
    return x;
  }

  /**
   * Gets the y-position of this canvas's top left corner.
   * @return the y-position
   */
  protected int getY() {
    return y;
  }

  /**
   * Gets the width of this canvas.
   * @return the width
   */
  protected int getWidth() {
    return width;
  }

  /**
   * Gets the height of this canvas.
   * @return the height
   */
  protected int getHeight() {
    return height;
  }

}

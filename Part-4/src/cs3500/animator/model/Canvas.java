package cs3500.animator.model;

import java.util.Objects;

/**
 * Class to represent the area on which the shapes are to be animated.
 */
public class Canvas implements ICanvas {

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

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Canvas)) {
      return false;
    }

    Canvas that = (Canvas) o;
    return this.x == that.x && this.y == that.y && this.width == that.width &&
            this.height == that.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, width, height);
  }

}

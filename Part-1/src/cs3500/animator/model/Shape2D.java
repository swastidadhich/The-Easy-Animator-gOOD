package cs3500.animator.model;

import java.util.Objects;

/**
 * An abstract class to represent a 2D shape.
 */

public abstract class Shape2D {

  Position2D position;
  int width;
  int height;
  Color color;

  /**
   * Constructs a 2D shape using a color, position, width, and height.
   *
   * @param color    color
   * @param position 2D position
   * @param width    width
   * @param height   height
   */

  public Shape2D(Color color, Position2D position, int width, int height) {
    if (color == null || position == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive");
    }
    if (position.isNegative()) {
      throw new IllegalArgumentException("Position cannot be negative");
    }
    if (!color.isValid()) {
      throw new IllegalArgumentException("Color not valid");
    }
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = height;
  }

  /**
   * Constructs a 2D shape using a color, position, and width which is initialized as the same as
   * the height.
   *
   * @param color    the color
   * @param position 2D position
   * @param width    width
   */

  // Used as a constructor for shapes such as a circle and square
  public Shape2D(Color color, Position2D position, int width) {
    if (width <= 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive");
    }
    if (position.isNegative()) {
      throw new IllegalArgumentException("Position cannot be negative");
    }
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = width;
  }

  // Returns whether this shape is equal to the given object
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Shape2D)) {
      return false;
    }

    Shape2D that = (Shape2D) o;
    return (this.color.equals(that.color) && this.position.equals(that.position)
        && this.width == that.width && this.height == that.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, position, width, height);
  }

  /**
   * Updates the shape at the given tick using the given motion.
   *
   * @param m    motion
   * @param tick tick
   */

  protected void updateShape(Motion2D m, int tick) {
    this.moveShape(m.positionAtTick(tick));
    this.changeColor(m.colorAtTick(tick));
    this.changeWidth(m.widthAtTick(tick));
    this.changeHeight(m.heightAtTick(tick));
  }

  // add hascode and overide it

  /**
   * Gets the 2D shape's x-position.
   *
   * @return the x-position
   */

  public int getPositionX() {
    return this.position.getX();
  }

  /**
   * Gets the 2D shape's y-position.
   *
   * @return the y-position
   */

  public int getPositionY() {
    return this.position.getY();
  }

  /**
   * Gets the 2D shape's quantity representing the red color.
   *
   * @return the red color
   */

  public int getRed() {
    return this.color.getRed();
  }

  /**
   * Gets the 2D shape's quantity representing the green color.
   *
   * @return the green color
   */

  public int getGreen() {
    return this.color.getGreen();
  }

  /**
   * Gets the 2D shape's quantity representing the blue color.
   *
   * @return the blue color
   */

  public int getBlue() {
    return this.color.getBlue();
  }

  /**
   * Gets the 2D shape's width.
   *
   * @return the width
   */

  public int getWidth() {
    return this.width;
  }

  /**
   * Gets the 2D shape's height.
   *
   * @return the height
   */

  public int getHeight() {
    return this.height;
  }

  /**
   * Moves this shape to the given position.
   *
   * @param newLoc new 2D position
   */

  public void moveShape(Position2D newLoc) {
    this.position = newLoc;
  }

  /**
   * Changes this shape's color to the given color.
   *
   * @param newColor new color
   */

  public void changeColor(Color newColor) {
    this.color = newColor;
  }

  /**
   * Changes this shape's width to the given width.
   *
   * @param newWidth new width
   */

  public void changeWidth(int newWidth) {
    this.width = newWidth;
  }

  /**
   * Changes this shape's height to the given height.
   *
   * @param newHeight new height
   */

  public void changeHeight(int newHeight) {
    this.height = newHeight;
  }
}

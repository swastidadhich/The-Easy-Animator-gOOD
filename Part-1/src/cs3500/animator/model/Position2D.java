package cs3500.animator.model;

import java.util.Objects;

/**
 * This class represents a 2D position.
 */
public final class Position2D {

  private int x;
  private int y;

  // returns true if x or y is negative
  protected boolean isNegative() throws IllegalArgumentException {
    return (this.x < 0 || this.y < 0);
  }

  /**
   * Initialize this object to the specified position.
   *
   * @param x x-coordinate
   * @param y y-coordinate
   */
  public Position2D(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  /**
   * Constructs the position with the v coordinate.
   *
   * @param v v-coordinate
   */
  public Position2D(Position2D v) {
    this.setX(v.x);
    this.setY(v.y);
  }

  /**
   * get the x coordinate of this position.
   *
   * @return
   */
  public int getX() {
    return x;
  }

  /**
   * get the y coordinate of this position.
   *
   * @return
   */
  public int getY() {
    return y;
  }

  /**
   * Set the x coordinate of this object.
   *
   * @param x x-coordinate
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Set the y coordiante of this object.
   *
   * @param y y-coordinate
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position2D)) {
      return false;
    }
    Position2D that = (Position2D) a;
    return (this.x == that.x && this.y == that.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }
}
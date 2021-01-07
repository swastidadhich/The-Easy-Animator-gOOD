package cs3500.animator.model;

import java.util.Objects;

/**
 * A class to represent a starting and ending motion for a shape.
 */
public class Motion2D implements IMotion2D {

  private final String name;
  private final int t1;
  private final int x1;
  private final int y1;
  private final int w1;
  private final int h1;
  private final int r1;
  private final int g1;
  private final int b1;
  private final int t2;
  private final int x2;
  private final int y2;
  private final int w2;
  private final int h2;
  private final int r2;
  private final int g2;
  private final int b2;

  /**
   * Constructs a Motion2D with a name, initial and final tick, x-position, y-position, width,
   * height, red color, green color, and blue color.
   * @param name the name of the shape this motion is for
   * @param t1 initial tick
   * @param x1 starting x-position
   * @param y1 starting y-position
   * @param w1 starting width
   * @param h1 starting height
   * @param r1 starting red color value
   * @param g1 starting green color value
   * @param b1 starting blue color value
   * @param t2 final tick
   * @param x2 ending x-position
   * @param y2 ending y-position
   * @param w2 ending width
   * @param h2 ending height
   * @param r2 ending red color value
   * @param g2 ending green color value
   * @param b2 ending blue color value
   * @throws IllegalArgumentException if the name is null,
   *                                     tick1 is greater than tick2,
   *                                     the ticks, width, height, or color values are less than 0,
   *                                     the color values were greater than 255,
   *                                     tick1 equals tick2 but initial state differs from the final
   */
  public Motion2D(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                  int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }

    if (t1 > t2) {
      throw new IllegalArgumentException("Starting tick cannot be greater than ending tick");
    }

    if (t1 < 0 || w1 < 0 || h1 < 0 || r1 < 0 || g1 < 0 || b1 < 0 || w2 < 0 || h2 < 0
            || r2 < 0 || g2 < 0 || b2 < 0) {
      throw new IllegalArgumentException("ticks, width, height, color values cannot be negative");
    }

    if (r1 > 255 || g1 > 255 || b1 > 255 || r2 > 255 || g2 > 255 || b2 > 255) {
      throw new IllegalArgumentException("Color values cannot be greater than 255");
    }

    if (t1 == t2 && (x1 != x2 || y1 != y2 || w1 != w2 || h1 != h2 || r1 != r2 || g1 != g2
            || b1 != b2)) {
      throw new IllegalArgumentException("Initial and final state must be the same if " +
              "starting tick is the same as the ending tick");
    }

    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  /**
   * Returns whether this motion overlaps with the given motion.
   * @param that the given motion
   * @return true if the motions overlap
   */
  protected boolean overlapWith(Motion2D that) {
    // if ticks overlap, return true
    if (that.t2 > this.t1 && that.t1 < this.t2) {
      return true;
    }

    // if motions share a tick, check the states are the same at the shared tick
    if (this.t1 == that.t2 && this.diffStartEnd(that)) {
      // return true if the states are not the same at the shared tick
      return true;
    }

    return this.t2 == that.t1 && that.diffStartEnd(this);
  }

  /**
   * Returns whether this motion has a different starting state than the given motion's ending
   * state.
   * @param that the given motion
   * @return true if this motion has a different starting state than the given's ending state
   */
  private boolean diffStartEnd(Motion2D that) {
    return ! (this.x1 == that.x2 && this.y1 == that.y2 && this.w1 == that.w2 && this.h1 == that.h2
            && this.r1 == that.r2 && this.g1 == that.g2 && this.b1 == that.b2);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getTick1() {
    return t1;
  }

  @Override
  public int getTick2() {
    return t2;
  }

  @Override
  public int getX1() {
    return x1;
  }

  @Override
  public int getX2() {
    return x2;
  }

  @Override
  public int getY1() {
    return y1;
  }

  @Override
  public int getY2() {
    return y2;
  }

  @Override
  public int getWidth1() {
    return w1;
  }

  @Override
  public int getWidth2() {
    return w2;
  }

  @Override
  public int getHeight1() {
    return h1;
  }

  @Override
  public int getHeight2() {
    return h2;
  }

  @Override
  public int getRed1() {
    return r1;
  }

  @Override
  public int getRed2() {
    return r2;
  }

  @Override
  public int getGreen1() {
    return g1;
  }

  @Override
  public int getGreen2() {
    return g2;
  }

  @Override
  public int getBlue1() {
    return b1;
  }

  @Override
  public int getBlue2() {
    return b2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Motion2D)) {
      return false;
    }

    Motion2D that = (Motion2D) o;
    return (this.name.equals(that.name) && this.x1 == that.x1 && this.y1 == that.y1
            && this.w1 == that.w1 && this.h1 == that.h1 && this.r1 == that.r1 && this.g1 ==
            that.g1 && this.b1 == that.b1 && this.t1 == that.t1 && this.x2 == that.x2 && this.y2
            == that.y2 && this.w2 == that.w2 && this.h2 == that.h2 && this.r2 == that.r2
            && this.g2 == that.g2 && this.b2 == that.b2 && this.t2 == that.t2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
  }

}

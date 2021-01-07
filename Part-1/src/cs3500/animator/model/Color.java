package cs3500.animator.model;

import java.util.Objects;

/**
 * A class to represent a RGB color.
 */
public class Color {

  int red;
  int green;
  int blue;

  /**
   * Constructs a color with a red, green, and blue value.
   *
   * @param red   red
   * @param green green
   * @param blue  blue
   */

  public Color(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Returns true if color is valid.
   *
   * @return if the color is valid
   */

  protected boolean isValid() {
    return (this.red >= 0 && this.red <= 255
        && this.green >= 0 && this.green <= 255
        && this.blue >= 0 && this.blue <= 255);
  }

  // Returns whether this color is the same as the given object
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Color)) {
      return false;
    }

    Color that = (Color) o;
    return (this.red == that.red && this.green == that.green && this.blue == that.blue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(red, green, blue);
  }

  /**
   * Gets the red.
   *
   * @return the red value
   */

  protected int getRed() {
    return this.red;
  }

  /**
   * Gets the green.
   *
   * @return the green value
   */

  protected int getGreen() {
    return this.green;
  }

  /**
   * Gets the blue.
   *
   * @return the blue value
   */

  protected int getBlue() {
    return this.blue;
  }

}

package cs3500.animator.provider.shapes;

import java.util.Objects;

/**
 * A factory for producing shapes.
 */
public final class ShapeFactory {

  /**
   * Creates a new view shape of the given type with the given attributes. If needed, a view shape
   * can be called a readonly shape and used by the model.
   *
   * @param type   the type of shape
   * @param x      the x-coordinate of the top-left corner of the new shape
   * @param y      the y-coordinate of the top-left corner of the new shape
   * @param width  the width of the new shape
   * @param height the height of the new shape
   * @param red    the red channel intensity of the new shape's color
   * @param green  the green channel intensity of the new shape's color
   * @param blue   the blue channel intensity of the new shape's color
   * @return the shape
   * @throws IllegalArgumentException if the color is invalid
   * @throws NullPointerException     if the type is null
   */
  public static IReadOnlyShape shape(ShapeType type, int x, int y, int width, int height, int red,
                                     int green, int blue) throws IllegalArgumentException,
          NullPointerException {
    Objects.requireNonNull(type);
    switch (type) {
      case OVAL:
        return new Oval(x, y, width, height, red, green, blue);
      case RECTANGLE:
        return new Rectangle(x, y, width, height, red, green, blue);
      default:
        throw new IllegalArgumentException("Invalid shape type.");
    }
  }
}

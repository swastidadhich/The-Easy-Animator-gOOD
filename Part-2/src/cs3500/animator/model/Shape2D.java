package cs3500.animator.model;

import java.util.Objects;

/**
 * A class to represent a 2D shape. Contains info on the shape's name and type.
 */
public class Shape2D implements IShape2D {

  private final String name;
  private final String type;

  /**
   * Constructs a shape with a name and type.
   * @param name the name of the shape
   * @param type the type of the shape
   */
  public Shape2D(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Shape2D)) {
      return false;
    }

    Shape2D that = (Shape2D) o;
    return (this.name.equals(that.name) && this.type.equals(that.type));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }

}


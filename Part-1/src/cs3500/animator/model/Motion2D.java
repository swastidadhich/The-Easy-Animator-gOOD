package cs3500.animator.model;

/**
 * A class to represent a starting and ending motion for a shape.
 */

public class Motion2D {

  String name;
  protected Shape2D shapeI;
  protected Shape2D shapeF;
  protected int tick1;
  protected int tick2;

  /**
   * Constructs a motion using a name, initial shape, final shape, starting tick, and ending tick.
   *
   * @param name   name of shape within the motion
   * @param shapeI initial shape
   * @param shapeF final shape
   * @param tick1  starting tick
   * @param tick2  ending tick
   */

  public Motion2D(String name, Shape2D shapeI, Shape2D shapeF, int tick1, int tick2) {
    this.name = name;
    this.shapeI = shapeI;
    this.shapeF = shapeF;
    this.tick1 = tick1;
    this.tick2 = tick2;
  }

  /**
   * Gets the name in the motion.
   *
   * @return the name
   */

  public String getName() {
    return name;
  }

  /**
   * Gets the starting tick.
   *
   * @return the starting tick
   */

  public int getTick1() {
    return tick1;
  }

  /**
   * Gets the ending tick.
   *
   * @return the ending tick
   */

  public int getTick2() {
    return tick2;
  }

  /**
   * Gets the initial shape.
   *
   * @return the initial shape
   */

  public Shape2D getShapeI() {
    return shapeI;
  }

  /**
   * Gets the final shape.
   *
   * @return the final shape
   */

  public Shape2D getShapeF() {
    return shapeF;
  }

  /**
   * Calculates the position at the given tick from the shape within a motion which contains the
   * given tick in its range.
   *
   * @param tick given tick
   * @return the position at the given tick
   * @throws IllegalArgumentException if the motion does not contain the tick in its range
   */

  protected Position2D positionAtTick(int tick) throws IllegalArgumentException {

    if (tick > tick2 || tick < tick1) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    int x;
    int y;

    x = (int) Math.round(numAtTick(shapeI.getPositionX(), shapeF.getPositionX(), tick));
    y = (int) Math.round(numAtTick(shapeI.getPositionY(), shapeF.getPositionY(), tick));

    return new Position2D(x, y);
  }

  /**
   * Calculates the color at the given tick from the shape within a motion which contains the given
   * tick in its range.
   *
   * @param tick given tick
   * @return the color at the given tick
   * @throws IllegalArgumentException if the motion does not contain the tick in its range
   */

  protected Color colorAtTick(int tick) throws IllegalArgumentException {

    if (tick > tick2 || tick < tick1) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    int r;
    int g;
    int b;

    r = (int) Math.round(numAtTick(shapeI.getRed(), shapeF.getRed(), tick));
    g = (int) Math.round(numAtTick(shapeI.getGreen(), shapeF.getGreen(), tick));
    b = (int) Math.round(numAtTick(shapeI.getBlue(), shapeF.getBlue(), tick));

    return new Color(r, g, b);
  }

  /**
   * Calculates the width at the given tick from the shape within a motion which contains the given
   * tick in its range.
   *
   * @param tick given tick
   * @return the width at the given tick
   * @throws IllegalArgumentException if the motion does not contain the tick in its range
   */

  protected int widthAtTick(int tick) throws IllegalArgumentException {

    if (tick > tick2 || tick < tick1) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    return (int) Math.round(numAtTick(shapeI.getWidth(), shapeF.getWidth(), tick));
  }

  /**
   * Calculates the height at the given tick from the shape within a motion which contains the given
   * tick in its range.
   *
   * @param tick given tick
   * @return the height at the given tick
   * @throws IllegalArgumentException if the motion does not contain the tick in its range
   */

  protected int heightAtTick(int tick) throws IllegalArgumentException {

    if (tick > tick2 || tick < tick1) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    return (int) Math.round(numAtTick(shapeI.getHeight(), shapeF.getHeight(), tick));
  }

  /**
   * Calculates the value of a number at the given tick between this motion's starting tick
   * (represented by the first number) and ending tick (represented by the second given number).
   *
   * @param tick given tick
   * @return the number at the given tick
   * @throws IllegalArgumentException if the motion does not contain the tick in its range
   */

  protected double numAtTick(int num1, int num2, double tick) {

    if (tick > tick2 || tick < tick1) {
      throw new IllegalArgumentException("Tick not in range of motion");
    }

    double deltaZ;
    double percentT;

    deltaZ = num2 - num1;
    percentT = (tick - tick1) / (tick2 - tick1);

    return (deltaZ * percentT) + num1;
  }

}
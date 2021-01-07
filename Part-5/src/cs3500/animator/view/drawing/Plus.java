package cs3500.animator.view.drawing;

/**
 * Class to represent a Plus.
 */
public class Plus implements IPlus {

  public int x1 = 0;
  public int y1 = 0;
  public int x2 = 0;
  public int y2 = 0;
  public int x3 = 0;
  public int y3 = 0;
  public int x4 = 0;
  public int y4 = 0;
  public int x5 = 0;
  public int y5 = 0;
  public int x6 = 0;
  public int y6 = 0;
  public int x7 = 0;
  public int y7 = 0;
  public int x8 = 0;
  public int y8 = 0;
  public int x9 = 0;
  public int y9 = 0;
  public int x10 = 0;
  public int y10 = 0;
  public int x11 = 0;
  public int y11 = 0;
  public int x12 = 0;
  public int y12 = 0;
  int width;
  int height;
  int x;
  int y;

  /**
   * Constructs a Plus with a width, height, x, and y.
   * @param width width
   * @param height height
   * @param x x
   * @param y y
   */
  public Plus(int width, int height, int x, int y) {
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return x1 +
        "," + y1 +
        "," + x2 +
        "," + y2 +
        "," + x3 +
        "," + y3 +
        "," + x4 +
        "," + y4 +
        "," + x5 +
        "," + y5 +
        "," + x6 +
        "," + y6 +
        "," + x7 +
        "," + y7 +
        "," + x8 +
        "," + y8 +
        "," + x9 +
        "," + y9 +
        "," + x10 +
        "," + y10 +
        "," + x11 +
        "," + y11 +
        "," + x12 +
        "," + y12;
  }

  @Override
  public void calculate() {
    x1 = x;
    y1 = y + height / 4;
    x2 = x + width / 4;
    y2 = y1;
    x3 = x2;
    y3 = y;
    y4 = y;
    x4 = x + (width * 3) / 4;
    x5 = x4;
    y5 = y2;
    x6 = x + width;
    y6 = y5;
    x7 = x6;
    y7 = y + (height * 3) / 4;
    x8 = x5;
    y8 = y7;
    x9 = x8;
    y9 = y + height;
    x10 = x3;
    y10 = y9;
    x11 = x10;
    y11 = y8;
    x12 = x1;
    y12 = y11;
  }

}

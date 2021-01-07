package cs3500.animator.view.inputdrawing;

/**
 * A class to represent a Rectangle which is used as an input.
 */

public class InputRect {


  int t = 0;   // t = ticks
  int x = 30;  // x = x-coordinate
  int y = 5;   // y = y-coordinate
  int w = 13;  // w = width
  int h = 50;  // h = height
  int r = 51;  // r = red
  int g = 102; // g = green
  int b = 255; // b = blue


  @Override
  public String toString() {
    return t + " " + x + " " + y + " " + w + " " + h + " " + r + " " + g + " " + b;
  }

  public void setT(int t) {
    this.t = t;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setW(int w) {
    this.w = w;
  }

  public void setH(int h) {
    this.h = h;
  }

  public void setR(int r) {
    this.r = r;
  }

  public void setG(int g) {
    this.g = g;
  }

  public void setB(int b) {
    this.b = b;
  }

  public int getT() {
    return t;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getW() {
    return w;
  }

  public int getH() {
    return h;
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

}

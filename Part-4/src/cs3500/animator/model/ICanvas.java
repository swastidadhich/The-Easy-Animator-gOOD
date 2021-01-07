package cs3500.animator.model;

/**
 * An interface for a canvas, the area for an animation.
 */
public interface ICanvas {

  /**
   * Gets the x-position of this canvas's top left corner.
   * @return the x-position
   */
  int getX();

  /**
   * Gets the y-position of this canvas's top left corner.
   * @return the y-position
   */
  int getY();

  /**
   * Gets the width of this canvas.
   * @return the width
   */
  int getWidth();

  /**
   * Gets the height of this canvas.
   * @return the height
   */
  int getHeight();

}

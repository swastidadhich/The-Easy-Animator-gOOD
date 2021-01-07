package cs3500.animator.provider.model;

import cs3500.animator.provider.shapes.ShapeType;

/**
 * This interface extends the functionality offered by readonly animations, and adds support for
 * mutation. Specifically, the bounds of a mutable animation can be set, shapes can be declared and
 * removed, and motions for shapes can be added.
 */
public interface IMutableAnimationModel extends IReadOnlyAnimationModel {

  /**
   * Sets the canvas bounds for this animation.
   *
   * @param x      the x-coordinate of the top-left corner of the animation canvas
   * @param y      the y-coordinate of the top-left corner of the animation canvas
   * @param width  the width of the animation canvas
   * @param height the width of the animation canvas
   * @throws IllegalArgumentException if width or height is negative
   */
  void setCanvas(int x, int y, int width, int height) throws IllegalArgumentException;

  /**
   * Creates a new shape in this animation with the given type and name.
   *
   * @param type the type of the shape
   * @param name the name of the shape
   * @throws NullPointerException     if type or name is null
   * @throws IllegalArgumentException if a shape with the name already exists
   */
  void addShape(ShapeType type, String name) throws NullPointerException, IllegalArgumentException;

  /**
   * Removes the shape with the given name from this animation.
   *
   * @param name the name of the shape
   * @throws NullPointerException     if name is null
   * @throws IllegalArgumentException if a shape with the name doesn't exist
   */
  void removeShape(String name) throws NullPointerException, IllegalArgumentException;

  /**
   * Adds a motion to this animation on the shape of the given name. A motion is a change between
   *    * two known states of shapes (the before and after states) at different ticks.
   *
   * @param name    the name of the shape
   * @param tick1   the tick the motion begins on
   * @param x1      the x-coordinate of the shape before the motion
   * @param y1      the y-coordinate before the motion
   * @param width1  the width of the shape before the motion
   * @param height1 the height of the shape before the motion
   * @param red1    the shape's red color channel intensity before the motion
   * @param green1  the shape's green color channel intensity before the motion
   * @param blue1   the shape's blue color channel intensity before the motion
   * @param tick2   the tick the motion ends on
   * @param x2      the x-coordinate of the shape after the motion
   * @param y2      the y-coordinate of the shape after the motion
   * @param width2  the width of the shape after the motion
   * @param height2 the height of the shape after the motion
   * @param red2    the red color channel intensity of this shape after the motion
   * @param green2  the green color channel intensity of this shape after the motion
   * @param blue2   the blue color channel intensity of this shape  after the motion
   * @throws NullPointerException     if name is null
   * @throws IllegalArgumentException if the shape doesn't exist in the animation, or if the motion
   *                                  is invalid
   */
  void addMotion(String name,
      int tick1, int x1, int y1, int width1, int height1, int red1, int green1, int blue1,
      int tick2, int x2, int y2, int width2, int height2, int red2, int green2, int blue2)
      throws NullPointerException, IllegalArgumentException;
}

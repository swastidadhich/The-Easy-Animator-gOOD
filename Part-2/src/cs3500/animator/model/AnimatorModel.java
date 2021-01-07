package cs3500.animator.model;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * The model for animating shapes. Contains the shapes within the animation, and each shapes
 * motions, or states during the animation.
 */

public interface AnimatorModel {

  /**
   * Adds a shape of the given name and type to this model.
   * @param name the name of the shape
   * @param type the type of shape
   * @throws IllegalArgumentException if a shape with the same name has already been added, the
   *                                     given name or type is null
   */
  void addShape(String name, String type);

  /**
   * Adds a motion with the given name and initial and final states to this model.
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
   * @throws IllegalArgumentException if a shape with the given name has not been added,
   *                            the motion's ticks overlaps with any current motions for that shape,
   *                            the motion's starting tick is greater than its ending tick,
   *                            the motion has a different state than another motion at a shared
   *                            tick, the motion arguments are invalid
   */
  void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                 int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * Gets this model's shapes as a list of shapes.
   * @return the shapes that have been added to this model
   */
  List<Shape2D> getShapes();

  /**
   * Gets the given shape's list of motions from the model.
   * @param shape the shape
   * @return the shape's list of motions
   * @throws IllegalArgumentException if the given shape is null, the given shape has not been added
   *                                  to the model
   */
  List<Motion2D> getMotionsFromShape(Shape2D shape);

  /**
   * Initializes the canvas for the model.
   * @param x the x-position of the top left corner
   * @param y the y-position of the top left corner
   * @param width canvas width
   * @param height canvas height
   * @throws IllegalArgumentException if the width or height is negative
   */
  void initCanvas(int x, int y, int width, int height);

  /**
   * Gets this model's canvas.
   * @return the canvas
   */
  int getCanvasX();

  int getCanvasY();

  int getCanvasWidth();

  int getCanvasHeight();

  /**
   * Gets this model's shapes and corresponding motions (directions).
   * @return this model's directions
   */
  LinkedHashMap<Shape2D, List<Motion2D>> getDirections();

}

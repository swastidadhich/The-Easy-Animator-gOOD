package cs3500.animator.view;

import cs3500.animator.model.Motion2D;

import java.util.List;

/**
 * An interface to represent an SVG view of an animation.
 */
public interface AnimatorSVG extends AnimatorView {

  /**
   * This is a helper method which helps with generating strings which help with generating
   * the shape and their attributes in the svg file.
   * @param t1 tick1
   * @param t2 tick2
   * @param attribute attribute
   * @param x x position
   * @param y y position
   * @return a string for the svg file
   */
  String animate(int t1, int t2, String attribute, String x, String y);

  /**
   * This is a helper method which helps with generating strings which help with the transformation
   * of the shapes in a svg file.
   * @param x1 starting x position
   * @param x2 ending x position
   * @param y1 starting y position
   * @param y2 ending y position
   * @param t1 tick
   * @param dur duration
   * @param type type
   * @return a string for the svg file
   */
  String animateTransform(int x1, int x2, int y1, int y2, double t1, double dur, String type);

  /**
   * This is a helper method which helps with actually translating and getting the shapes to
   * move, resize and change color.
   * @param lom list of motions
   * @return a string for the svg file
   */
  String animateMotion(List<Motion2D> lom);

  /**
   * This helper method helps in generating strings for the svg file for a rectangle and its
   * attributes (x = x-coordinate, y = y-coordinate, width, height & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  String rectangle(List<Motion2D> lom, int id);

  /**
   * This helper method helps in generating strings for the svg file for an ellipse and its
   * attributes (x = x-coordinate, y = y-coordinate, width, height & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  String ellipse(List<Motion2D> lom, int id);

  /**
   * This helper method helps in generating strings for the svg file for a circle and its
   * attributes (x = x-coordinate, y = y-coordinate, width & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  String circle(List<Motion2D> lom, int id);

}

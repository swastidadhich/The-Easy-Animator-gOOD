package cs3500.animator.model;

/**
 * Interface to represent a 2D motion.
 */
public interface IMotion2D {

  /**
   * Gets the name in the motion.
   * @return the name
   */
  String getName();

  /**
   * Gets the starting tick.
   * @return the starting tick
   */
  int getTick1();

  /**
   * Gets the ending tick.
   * @return the ending tick
   */
  int getTick2();

  /**
   * Gets the starting x-position.
   * @return the starting x-position
   */
  int getX1();

  /**
   * Gets the ending x-position.
   * @return the ending x-position
   */
  int getX2();

  /**
   * Gets the starting y-position.
   * @return the starting y-position
   */
  int getY1();

  /**
   * Gets the ending y-position.
   * @return the ending y-position
   */
  int getY2();

  /**
   * Gets the starting width.
   * @return the starting width
   */
  int getWidth1();

  /**
   * Gets the ending width.
   * @return the ending width
   */
  int getWidth2();

  /**
   * Gets the starting height.
   * @return the starting height
   */
  int getHeight1();

  /**
   * Gets the ending height.
   * @return the ending height
   */
  int getHeight2();

  /**
   * Gets the starting red color value.
   * @return the starting red color value
   */
  int getRed1();

  /**
   * Gets the ending red color value.
   * @return the ending red color value
   */
  int getRed2();

  /**
   * Gets the starting green color value.
   * @return the starting green color value
   */
  int getGreen1();

  /**
   * Gets the ending green color value.
   * @return the ending green color value
   */
  int getGreen2();

  /**
   * Gets the starting blue color value.
   * @return the starting blue color value
   */
  int getBlue1();

  /**
   * Gets the ending blue color value.
   * @return the ending blue color value
   */
  int getBlue2();
}

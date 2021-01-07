package cs3500.animator.provider.controller;

/**
 * A set of features which allow for interactivity between a controller class and view
 * implementation.
 */
public interface Features {

  /**
   * Restart the Animation from the last displayed tick.
   */
  void resume();

  /**
   * Stop the Animation at the current displayed tick.
   */
  void pause();

  /**
   * Start the Animation at the first tick.
   */
  void reset();

  /**
   * Sets the boolean flag for whether an Animation should loop back to the beginning after it
   * reaches its end.
   *
   * @param shouldLoop the boolean flag
   */
  void setLooping(boolean shouldLoop);

  /**
   * Sets the speed of the animation program.
   *
   * @param speed the speed of the animation
   * @throws IllegalArgumentException if the speed is non-positive
   */
  void setSpeed(int speed) throws IllegalArgumentException;
}

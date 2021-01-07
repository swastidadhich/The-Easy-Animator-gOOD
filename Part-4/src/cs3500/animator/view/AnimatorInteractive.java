package cs3500.animator.view;

import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * An interface to represent the interactive view of the animation.
 */
public interface AnimatorInteractive extends AnimatorView {

  /**
   * Set the listener for any actions.
   * @throws IllegalArgumentException if the given listener is null
   */
  void setAListener(ActionListener listener) throws IllegalArgumentException;

  /**
   * Set the listener for any keys.
   * @throws IllegalArgumentException if the given listener is null
   */
  void setKListener(KeyListener listener) throws IllegalArgumentException;

  /**
   * Render the visual view of the given shape at the frame of the given tick.
   * @param shape shape
   * @param motion motion
   * @param tick tick
   * @throws IllegalArgumentException if the given shape or motion is negative, if the tick is
   *                                  negative
   */
  void render(Shape2D shape, Motion2D motion, int tick) throws IllegalArgumentException;

  /**
   * Increase the tempo of the view by 1 if it will be below the max speed.
   * @throws IllegalStateException if the tempo is already at or above the max speed
   */
  void speedUp() throws IllegalStateException;

  /**
   * Decrease the tempo of the view by 1 if it will be above the min speed.
   * @throws IllegalStateException if the tempo is already at or below the min speed
   */
  void slowDown();

  /**
   * Set the text label to the current speed or show that the speed is at its max or min.
   * @param speed the current speed
   * @throws IllegalArgumentException if the given speed is negative
   */
  void setCurrentSpeed(double speed) throws IllegalArgumentException;

  /**
   * Set the text for the loop button showing the current status, enabled or disabled.
   * @param loop the loop status
   */
  void setLoopStatus(boolean loop);

  /**
   * Get this view's tempo (ticks/sec).
   * @return the tempo
   */
  double getTempo();

}

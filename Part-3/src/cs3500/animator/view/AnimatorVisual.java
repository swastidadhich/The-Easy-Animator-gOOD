package cs3500.animator.view;

import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;

/**
 * An interface for the visual view of an animation.
 */
public interface AnimatorVisual extends AnimatorView {

  /**
   * Render the visual view of the given shape at the frame of the given tick.
   *
   * @param tick the tick
   * @param s    shape
   * @param m    motion
   * @throws IllegalArgumentException if the given shape or motion is negative, if the tick is
   *                                  negative
   */
  void render(int tick, Shape2D s, Motion2D m) throws IllegalArgumentException;

  /**
   * Gets this view's tempo (ticks/second).
   *
   * @return the tempo
   */
  double getTempo();

}

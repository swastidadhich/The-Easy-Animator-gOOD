package cs3500.animator.provider.model;

import java.util.Map;

/**
 * Represents an animation that can only be observed, and not mutated. Animations have canvas
 * bounds, defined by a top-left corner coordinate and width & height. Animations can also satisfy
 * requests timelines for every shape described in them. If needed, the last tick (and therefore the
 * length) of an animation can be requested.
 */
public interface IReadOnlyAnimationModel {

  /**
   * Gets the x-coordinate of the top-left corner of the canvas of this animation.
   *
   * @return the x-coordinate
   */
  int getCanvasX();

  /**
   * Gets the y-coordinate of the top-left corner of the canvas of this animation.
   *
   * @return the y-coordinate
   */
  int getCanvasY();

  /**
   * Gets the width of the canvas of this animation.
   *
   * @return the width
   */
  int getCanvasWidth();

  /**
   * Gets the height of the canvas of this animation.
   *
   * @return the height
   */
  int getCanvasHeight();

  /**
   * Returns a list of timelines in this animation, in the order that their respective shapes were
   * added.
   *
   * @return the timelines
   */
  Map<String, IReadOnlyTimeline> getTimelines();

  /**
   * Gets the last tick in this animation, or 0 if there are no ticks yet.
   *
   * @return the tick
   */
  int getLastTick();
}

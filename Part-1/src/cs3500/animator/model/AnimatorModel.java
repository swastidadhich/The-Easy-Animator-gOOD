package cs3500.animator.model;

import java.util.List;

/**
 * The model for animating shapes: this maintains the state and enforces it.
 */

public interface AnimatorModel {

  /**
   * The model for animating shapes: this maintains the state and enforces the state and the
   * invariant.
   *
   * <p>Starts a new animation.
   * * The shapes to be used and their location, dimension and color are specified by the the given
   * input. * Initializes the motions, list of shapes, and tick at 1 to start the animation.</p>
   *
   * @param llom the list of list of motions representing the directions for the animation
   * @throws IllegalArgumentException if the given list of directions is invalid:
   *                                  - the list of list of motions is null
   *                                  - a list of motions within the directions is null
   *                                  - a motion within the directions is null
   *                                  - the ticks are not positive
   *                                  - the start of a motion is not the same as the end of a
   *                                    motion in the previous motion if one exists
   *                                  - there are overlapping ticks or gap between ticks
   *                                  - ending tick is less than starting tick
   */

  void startAnimation(List<List<Motion2D>> llom) throws IllegalArgumentException;

  /**
   * Updates the list of shapes in the model to match the state at the current tick.
   *
   * @param tick the given tick
   * @throws IllegalArgumentException if the tick is not positive
   * @throws IllegalStateException if the animation has not been started
   */

  void updateAnimation(int tick) throws IllegalArgumentException, IllegalStateException;

  /**
   * Returns a copy of the model's list of shapes.
   *
   * @return the list of shapes
   * @throws IllegalStateException if the animation has not been started
   */

  List<Shape2D> getShapes() throws IllegalStateException;

  /**
   * Returns a copy of the model's list of list of motions representing the directions.
   *
   * @return the list of list of motions
   * @throws IllegalStateException if the animation has not been started
   */

  List<List<Motion2D>> getMotions() throws IllegalStateException;

  /**
   * Returns the model's current tick.
   *
   * @return the tick
   */
  int getTick();
}

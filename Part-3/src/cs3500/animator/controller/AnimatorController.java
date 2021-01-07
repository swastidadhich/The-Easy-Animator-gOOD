package cs3500.animator.controller;

/**
 * This is the interface for the AnimatorController.
 */

public interface AnimatorController {

  /**
   * Method for beginning and playing an animation.
   *
   * @throws IllegalStateException if the animation cannot be rendered
   */
  void playAnimation() throws IllegalStateException;

}

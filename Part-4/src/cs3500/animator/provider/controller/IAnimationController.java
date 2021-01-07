package cs3500.animator.provider.controller;

import java.io.IOException;

/**
 * Represents a controller that handles the relationship between animation models and views. Can
 * specify the speed of animation playback, as well as where the output of a view should be
 * directed, if applicable. Concrete implementations define the defaults if no output or speed is
 * specified.
 */
public interface IAnimationController {

  /**
   * Runs the controller to process and/or display animations.
   */
  void run() throws IOException;
}

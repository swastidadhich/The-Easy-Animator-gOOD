package cs3500.animator.controller;

/**
 * An interface for a controller of an interactive animation, allows interaction with the animation
 * with button presses and key presses, extends the AnimatorController interface.
 */
public interface InteractiveController extends AnimatorController {

  /**
   * Restarts the animation, enables or disables looping, or slows down or speeds up the tempo
   * depending on the given action command of an action event.
   *
   * @param actionCommand action command
   * @throws IllegalArgumentException if the action command has no effect
   */
  void executeAction(String actionCommand) throws IllegalArgumentException;

  /**
   * Pauses, resumes/starts the animation depending on the key code of a key event its given. A
   * space bar press will pause/resume/start.
   *
   * @param keyCode key code
   * @throws IllegalArgumentException if the key code has no effect
   */
  void executeKey(int keyCode) throws IllegalArgumentException;

}

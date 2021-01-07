package cs3500.animator.provider.view;

/**
 * A textual representation of an Animation.
 */
public interface ITextualAnimationView extends IAnimationView {

  /**
   * Sets the textual output of the animation view.
   *
   * @param output the output appendable
   * @throws NullPointerException if the output is null
   */
  void setOutput(Appendable output) throws NullPointerException;

  /**
   * Sets the speed of the Animation.
   *
   * @param speed the speed, in ticks/second
   * @throws IllegalArgumentException if the speed is non-positive
   */
  void setSpeed(int speed) throws IllegalArgumentException;

  /**
   * Generates a textual representation of the Animation and saves it to the output specified, or
   * System.out if no output is specified.
   */
  void render();
}

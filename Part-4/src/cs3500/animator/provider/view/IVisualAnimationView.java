package cs3500.animator.provider.view;

/**
 * A visual representation of an Animation.
 */
public interface IVisualAnimationView extends IAnimationView {

  /**
   * Generates a visual representation of the Animation at the given tick.
   *
   * @param tick the tick
   */
  void renderTick(int tick);
}

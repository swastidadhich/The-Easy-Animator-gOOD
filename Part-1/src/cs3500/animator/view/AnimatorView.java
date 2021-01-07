package cs3500.animator.view;

import cs3500.animator.model.AnimatorModel;

import java.io.IOException;

/**
 * An interface to represent the view of the animation. Renders a {@link AnimatorModel} in some
 * manner.
 */

public interface AnimatorView {

  /**
   * Renders a model in some manner (e.g. as text, or as graphics, etc.).
   *
   * @throws IOException if the rendering fails for some reason
   */

  void render() throws IOException;
}
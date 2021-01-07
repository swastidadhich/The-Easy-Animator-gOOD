package cs3500.animator.controller;

import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.SVGAnimatorView;
import cs3500.animator.view.TextualTimeAnimatorView;

import java.io.IOException;

/**
 * Controller implementation for rendering a textual view or SVG view of an animation.
 */
public class EasyAnimatorController implements AnimatorController {

  private final AnimatorView v;

  /**
   * Constructs an EasyAnimatorController with an AnimatorView.
   * @param v textual view
   * @throws IllegalArgumentException if the view is null
   */
  public EasyAnimatorController(TextualTimeAnimatorView v) {
    if (v == null) {
      throw new IllegalArgumentException("View cannot be null");
    }
    this.v = v;
  }

  /**
   * Constructs an EasyAnimatorController with an AnimatorView.
   * @param v SVG view
   * @throws IllegalArgumentException if the view is null
   */
  public EasyAnimatorController(SVGAnimatorView v) {
    if (v == null) {
      throw new IllegalArgumentException("View cannot be null");
    }
    this.v = v;
  }

  @Override
  public void playAnimation() throws IllegalArgumentException {
    try {
      v.render();
    } catch (IOException io) {
      throw new IllegalArgumentException("Cannot render view");
    }
  }

}


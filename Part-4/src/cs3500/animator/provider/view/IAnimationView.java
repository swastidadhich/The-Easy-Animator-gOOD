package cs3500.animator.provider.view;

import cs3500.animator.provider.model.IReadOnlyAnimationModel;

/**
 * Defines how an animation can be viewed. Animation views allow implementations to declare outputs
 * if a rendering is textual by nature, but by default this operation is unsupported.
 */
public interface IAnimationView {

  /**
   * Sets the view model that this view should pull information from when rendering.
   *
   * @param viewModel the view model
   */
  void setViewModel(IReadOnlyAnimationModel viewModel);
}

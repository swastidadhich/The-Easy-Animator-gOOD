package cs3500.animator.provider.view;

import cs3500.animator.provider.controller.Features;

/**
 * Describes a view which can support features. Features allow for user interactivity, and
 * interactivity between the view and the controller.
 */
public interface IComplexVisualAnimationView extends IVisualAnimationView {

  /**
   * Set the Features object to be used as the listener callback.
   *
   * @param features the Features object
   */
  void setFeaturesListener(Features features);

  /**
   * Sets the speed for the this view to display.
   *
   * @param speed the speed
   */
  void setDisplayedSpeed(int speed);

  /**
   * Delegates a "play" event to a listener.
   */
  void handlePlay();

  /**
   * Delegates a "pause" event to a listener.
   */
  void handlePause();

  /**
   * Delegates a "reset" event to a listener.
   */
  void handleReset();

  /**
   * Delegates a "toggle looping" event to a listener.
   */
  void handleToggleLooping(boolean shouldLoop);

  /**
   * Delegates a "update speed" event to a listener.
   */
  void handleUpdatedSpeed(int speed);
}

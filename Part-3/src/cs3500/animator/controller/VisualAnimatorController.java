package cs3500.animator.controller;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.AnimatorVisual;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller implementation for a visual animation view.
 */
public class VisualAnimatorController implements AnimatorController {

  private Timer timer;
  protected AnimatorModel model;
  protected AnimatorVisual view;

  /**
   * Constructs a VisualAnimatorController with a model and a visual view.
   *
   * @param model the model
   * @param view  visual view
   * @throws IllegalArgumentException if the model or controller is null.
   */
  public VisualAnimatorController(AnimatorModel model, AnimatorVisual view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and/or controller cannot be null");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void playAnimation() throws IllegalArgumentException {
    timer = new Timer((int) (1000 / view.getTempo()), new ActionListener() {
      int tick = 1;

      @Override
      public void actionPerformed(ActionEvent e) {

        int lastTick = model.getLastTick();

        for (Shape2D s : model.getDirections().keySet()) {
          for (Motion2D m : model.getDirections().get(s)) {
            // if this motion contains the tick
            if (tick >= m.getTick1() && tick <= m.getTick2()) {
              // render
              view.render(tick, s, m);
            }
          }
        }

        // if the ticks are over stop the animation
        if (tick > lastTick) {
          timer.stop();
        }
        tick++;
      }

    });
    timer.start();
  }

}

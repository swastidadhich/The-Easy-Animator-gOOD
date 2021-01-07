package cs3500.animator.provider.controller;

import cs3500.animator.provider.model.IReadOnlyTimeline;
import cs3500.animator.provider.view.IComplexVisualAnimationView;
import cs3500.animator.provider.model.IReadOnlyAnimationModel;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provider controller implementation for interacting with an animation by being able to
 * pause/resume/start, restart, loop, and alter the speed of the controller.
 */
public class ComplexAnimationController implements IAnimationController, Features {

  private Timer timer;
  public IComplexVisualAnimationView view;
  private final IReadOnlyAnimationModel model;
  public int tick;
  private boolean shouldLoop;
  private int tempo;
  private boolean isPaused;

  /**
   * Constructs a ComplexAnimationController with a model, view, and tempo.
   * @param model model
   * @param view view
   * @param tempo speed (tick/second)
   */
  public ComplexAnimationController(IReadOnlyAnimationModel model,
                                    IComplexVisualAnimationView view, int tempo) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and/or view cannot be null");
    }
    this.model = model;
    this.view = view;
    this.tick = this.getModelFirstTick();
    this.tempo = tempo;
    this.shouldLoop = false;
    this.isPaused = false;
  }

  @Override
  public void run() {

    view.setViewModel(model);
    view.setFeaturesListener(this);
    view.setDisplayedSpeed(tempo);

    timer = new Timer((int) (1000 / tempo), new ActionListener() {
      int time = 1;
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.setDelay((int) (1000 / tempo));
        int lastTick = model.getLastTick();

        view.renderTick(tick);

        // loop if loop is enabled
        if (! isPaused && tick >= lastTick && shouldLoop) {
          tick = 1;
        }
        else if (! isPaused) {
          tick++;
        }

        time++;
      }

    });
    timer.start();
  }

  @Override
  public void resume() {
    if (isPaused) {
      isPaused = false;
    }
  }

  @Override
  public void pause() {
    if (! isPaused) {
      isPaused = true;
    }
  }

  @Override
  public void reset() {
    tick = this.getModelFirstTick();
  }

  @Override
  public void setLooping(boolean shouldLoop) {
    this.shouldLoop = shouldLoop;
  }

  @Override
  public void setSpeed(int speed) throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("Speed must be positive");
    }
    tempo = speed;
    view.setDisplayedSpeed(tempo);
  }

  /**
   * Get the first tick in the model.
   * @return the starting tick in the model
   */
  private int getModelFirstTick() {

    int firstTick = -1;

    for (IReadOnlyTimeline timeline : model.getTimelines().values()) {
      for (Integer i : timeline.getKeyTicks()) {
        if (firstTick == -1) {
          firstTick = i;
        }
        else if (i < firstTick) {
          firstTick = i;
        }
      }
    }

    if (firstTick < 0) {
      throw new IllegalArgumentException("Cannot have negative first tick");
    }

    return firstTick;
  }
}


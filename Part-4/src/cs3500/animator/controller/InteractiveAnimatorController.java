package cs3500.animator.controller;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.AnimatorInteractive;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller implementation for interacting with an animation by being able to
 * pause/resume/start, restart, loop, and alter the speed of the controller.
 */
public class InteractiveAnimatorController implements InteractiveController, ActionListener,
        KeyListener {

  private Timer timer;
  public AnimatorInteractive view;
  private final AnimatorModel model;
  public int tick;
  public boolean paused;
  public boolean loop;

  /**
   * Constructs an InteractiveAnimatorController with a model and an interactive view.
   * @param model model
   * @param view interactive view
   * @throws IllegalArgumentException if the model or controller is null
   */
  public InteractiveAnimatorController(AnimatorModel model, AnimatorInteractive view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and/or controller cannot be null");
    }
    this.model = model;
    this.view = view;
    this.tick = model.getFirstTick();
    this.paused = false;
    this.loop = false;
  }

  // constructor for testing
  /**
   * Constructs an InteractiveAnimatorController with a model, an interactive view, and a tick.
   * @param model model
   * @param view view
   * @param tick tick
   * @throws IllegalArgumentException if the model or controller is null
   */
  public InteractiveAnimatorController(AnimatorModel model, AnimatorInteractive view, int tick) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and/or controller cannot be null");
    }
    this.model = model;
    this.view = view;
    this.tick = tick;
    this.paused = false;
    this.loop = false;
  }

  // constructor for testing
  /**
   * Constructs an InteractiveAnimatorController with a model, an interactive view, a tick, and
   * booleans representing if the animation is paused or looping.
   * @param model model
   * @param view view
   * @param tick tick
   * @param paused paused
   * @param loop looping
   * @throws IllegalArgumentException if the model or controller is null
   */
  public InteractiveAnimatorController(AnimatorModel model, AnimatorInteractive view, int tick,
                                       boolean paused, boolean loop) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and/or controller cannot be null");
    }
    this.model = model;
    this.view = view;
    this.tick = tick;
    this.paused = paused;
    this.loop = loop;
  }

  @Override
  public void playAnimation() throws IllegalArgumentException {

    view.setAListener(this);
    view.setKListener(this);

    timer = new Timer((int) (1000 / view.getTempo()), new ActionListener() {
      int time = 1;
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.setDelay((int) (1000 / view.getTempo()));
        int lastTick = model.getLastTick();

        for (Shape2D s : model.getDirections().keySet()) {
          for (Motion2D m : model.getDirections().get(s)) {
            // if this motion contains the tick
            if (tick >= m.getTick1() && tick <= m.getTick2()) {
              // render
              view.render(s, m, tick);
            }
          }
        }

        // loop if loop is enabled
        if (! paused && tick >= lastTick && loop) {
          tick = model.getFirstTick();
        }
        else if (! paused) {
          tick++;
        }

        time++;
      }

    });
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    executeAction(e.getActionCommand());
  }

  @Override
  public void executeAction(String action) {
    // slow down, speed up, restart with buttons
    switch (action) {
      case "Speed Up":
        view.speedUp();
        view.setCurrentSpeed(view.getTempo());
        break;
      case "Slow Down":
        view.slowDown();
        view.setCurrentSpeed(view.getTempo());
        break;
      case "Restart":
        // if paused don't restart?
        tick = model.getFirstTick();
        break;
      case "Loop":
        loop = ! loop;
        view.setLoopStatus(loop);
        break;
      default:
        throw new IllegalArgumentException("Invalid action command");
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // we do not need to implement it for our purpose
  }

  @Override
  public void keyPressed(KeyEvent e) {
    executeKey(e.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // we do not need to implement it for our purpose
  }

  @Override
  public void executeKey(int key) throws IllegalArgumentException {
    // Pause/resume/start with space bar key
    if (key == KeyEvent.VK_SPACE) {
      paused = ! paused;
    }
    else {
      throw new IllegalArgumentException("Key has no effect");
    }
  }
}

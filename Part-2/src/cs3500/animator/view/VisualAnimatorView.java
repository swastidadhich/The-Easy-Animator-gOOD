package cs3500.animator.view;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.drawing.DrawingPanel;
import cs3500.animator.view.drawing.IViewShape;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class to represent a visual animation of the model.
 */
public class VisualAnimatorView extends JFrame implements AnimatorView {

  private final DrawingPanel drawingPanel;
  private final AnimatorModel model;
  private Timer timer;
  private final double tempo;

  /**
   * Constructs a VisualAnimatorView with a model and tempo. Initializes the canvas size,
   * creates a drawingPanel and scroll bars.
   * @param model the model
   * @param tempo speed in ticks/second
   * @throws IllegalArgumentException if the model is null or tempo is negative
   */
  public VisualAnimatorView(AnimatorModel model, double tempo) {
    super();

    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    if (tempo < 0) {
      throw new IllegalArgumentException("Tempo cannot be negative");
    }

    this.model = model;
    this.tempo = tempo;

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setSize(model.getCanvasWidth(), model.getCanvasHeight());
    setBounds(model.getCanvasX(), model.getCanvasY(), model.getCanvasWidth(),
            model.getCanvasHeight());

    drawingPanel = new DrawingPanel();
    drawingPanel.setPreferredSize(new Dimension(1000, 1000));
    add(drawingPanel);

    JScrollPane scrollPane = new JScrollPane(drawingPanel);
    add(scrollPane);

    setVisible(true);
  }

  @Override
  public void render() {

    timer = new Timer((int) (1000 / tempo), new ActionListener() { // tempo goes here (milliseconds)
      // every 100 milliseconds, this method gets called (10 ticks per second)
      int tick = 1;
      @Override
      public void actionPerformed(ActionEvent e) {

        Utilities util = new Utilities();
        int lastTick = util.getLastTick(model.getDirections());

        for (Shape2D shape : model.getDirections().keySet()) {
          for (Motion2D m : model.getDirections().get(shape)) {
            // if this motion contains the tick
            if (tick >= m.getTick1() && tick <= m.getTick2()) {
              // tween the shape
              IViewShape s = util.tween(shape, m, tick);

              drawingPanel.drawShape(s);
            }
          }
        }
        //repaints
        refresh();

        // if the ticks are over stop the animation
        if (tick > lastTick) {
          timer.stop();
        }
        tick++;
      }

    });
    timer.start();
  }

  /**
   * Refreshes the drawing panel so that repainting occurs.
   */
  private void refresh() {
    drawingPanel.repaint();
  }
}

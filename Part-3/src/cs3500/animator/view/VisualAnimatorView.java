package cs3500.animator.view;

import cs3500.animator.model.Canvas;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.drawing.DrawingPanel;
import cs3500.animator.view.drawing.IViewShape;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * A class to represent a visual animation of the model.
 */
public class VisualAnimatorView extends JFrame implements AnimatorVisual {

  private final DrawingPanel drawingPanel;
  private final double tempo;

  /**
   * Constructs a VisualAnimatorView with a model and tempo. Initializes the canvas size, creates a
   * drawingPanel and scroll bars.
   *
   * @param canvas the model
   * @param tempo  speed in ticks/second
   * @throws IllegalArgumentException if the model is null or tempo is negative
   */
  public VisualAnimatorView(Canvas canvas, double tempo) {
    super();

    if (canvas == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    if (tempo < 0) {
      throw new IllegalArgumentException("Tempo cannot be negative");
    }

    this.tempo = tempo;

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setSize(canvas.getWidth(), canvas.getHeight());
    setBounds(canvas.getX(), canvas.getY(), canvas.getWidth(),
        canvas.getHeight());

    drawingPanel = new DrawingPanel();
    drawingPanel.setPreferredSize(new Dimension(1000, 1000));
    add(drawingPanel);

    JScrollPane scrollPane = new JScrollPane(drawingPanel);
    add(scrollPane);

    setVisible(true);
  }

  @Override
  public void render() {
    throw new UnsupportedOperationException("invalid");
  }

  // take in shapes and motions
  @Override
  public void render(int tick, Shape2D shape, Motion2D motion) throws IllegalArgumentException {

    if (shape == null || motion == null) {
      throw new IllegalArgumentException("Shape and/or motion cannot be null");
    }

    if (tick < 0) {
      throw new IllegalArgumentException("Tick cannot be negative");
    }

    Utilities util = new Utilities();
    // tween shape
    IViewShape s = util.tween(shape, motion, tick);
    // draw shape
    drawingPanel.drawShape(s);

    refresh();
  }

  @Override
  public double getTempo() {
    return tempo;
  }

  /**
   * Refreshes the drawing panel so that repainting occurs.
   */
  private void refresh() {
    drawingPanel.repaint();
  }
}

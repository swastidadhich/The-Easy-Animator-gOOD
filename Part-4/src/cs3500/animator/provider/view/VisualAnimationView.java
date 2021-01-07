package cs3500.animator.provider.view;

import cs3500.animator.provider.model.IReadOnlyAnimationModel;
import cs3500.animator.provider.model.IReadOnlyTimeline;
import cs3500.animator.provider.shapes.IReadOnlyShape;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * A view that visually displays an animation using a Swing GUI. This view does not support
 * rendering to a textual output. Visual views do not support looping.
 */
public class VisualAnimationView extends JFrame implements IVisualAnimationView {

  protected final DrawingPanel drawingPanel;
  protected final Map<String, Tweener> tweeners;

  /**
   * Constructs a new visual view.
   */
  public VisualAnimationView() {
    super();

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.drawingPanel = new DrawingPanel();
    JScrollPane scrollPane = new JScrollPane(this.drawingPanel);
    this.add(scrollPane);

    this.tweeners = new LinkedHashMap<>();

    this.setVisible(true);
  }

  @Override
  public void renderTick(int tick) {
    for (Tweener tweener : tweeners.values()) {
      Optional<IReadOnlyShape> shape = tweener.getShapeAt(tick);
      shape.ifPresent(drawingPanel::drawShape);
    }
    drawingPanel.repaint();
  }

  @Override
  public void setViewModel(IReadOnlyAnimationModel viewModel) {
    Objects.requireNonNull(viewModel);
    this.tweeners.clear();
    for (IReadOnlyTimeline timeline : viewModel.getTimelines().values()) {
      Tweener tweener = new Tweener();
      this.tweeners.put(timeline.getShapeName(), tweener);
      for (int keyTick : timeline.getKeyTicks()) {
        IReadOnlyShape shape = timeline.getShapeAtKeyTick(keyTick);
        tweener.addKeyTick(keyTick, shape);
      }
    }

    this.drawingPanel.setXY(viewModel.getCanvasX(), viewModel.getCanvasY());
    this.drawingPanel.setPreferredSize(
        new Dimension(viewModel.getCanvasWidth(), viewModel.getCanvasHeight()));
    this.getContentPane().setPreferredSize(
        new Dimension(viewModel.getCanvasWidth(), viewModel.getCanvasHeight()));
    this.pack();
  }
}
